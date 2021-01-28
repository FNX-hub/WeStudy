package logic.control.gui;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.model.Subject;
import logic.model.bean.MeetingBean;
import logic.model.bean.UserBean;
import logic.model.bean.UserType;
import logic.model.bean.WrongDeclarationCustomException;
import logic.view.boundary.ManageMeetingBoundary;

public class BookMeetingFxControl extends Subject implements ManageMeetingBoundary {

	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private GridPane root; 
	@FXML
	private Label lblSubject; 
	@FXML
	private ComboBox<UserBean> cbSubject;
	@FXML
	private DatePicker dpDate;
	@FXML
	private TextArea tarMessage;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnNext;
	
	private UserBean session;
	private static final String CONFIRM = "Meeting with %s in date %s%nMessage: %s";
	
	public void setUserSession(UserBean session) {
		this.session = session;
		if(session.getType().equals(UserType.PARENT)) {
			lblSubject.setText("Professor:");
			cbSubject.setPromptText("Select professor");
		}
		else {
			lblSubject.setText("Parent:");
			cbSubject.setPromptText("Select student parent");
		}
		cbSubject.setItems(FXCollections.observableArrayList(getUserToMeet(session)));
	}

	@FXML
	private void initialize() {
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initStyle(StageStyle.DECORATED);
		stage.setTitle("Book Meeting");
		cbSubject.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> {
					cbSubject.setValue(newValue);
					cbSubject.setAccessibleText(newValue.getSurname());
				});
	}

	@FXML
	private void cancel() {
		stage.close();
	}
	
	private MeetingBean meetingBeanCreator() {
		String message;
		if(tarMessage.getText().isBlank()) {
			message = "No message";
		}
		else {
			message = tarMessage.getText();			
		}
		try {
			if(session.getType().equals(UserType.PROFESSOR)) {
				return  new MeetingBean(
						cbSubject.getValue().getId(),
						session.getId(),
						dpDate.getValue(),
						message);
			}
			return new MeetingBean(
					session.getId(),
					cbSubject.getValue().getId(),
					dpDate.getValue(),
					message);
		} catch(WrongDeclarationCustomException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Invalid information in form");
			alert.initStyle(StageStyle.DECORATED);
			alert.showAndWait();
			return null;
		}
	}
	
	@FXML
	public void next() {
		if(cbSubject.getValue()== null || dpDate.getValue() == null) return;
		MeetingBean bean = meetingBeanCreator();
		if(bean!=null) {
			bookMeeting(bean);
			
			// ALERT CREATION 
			// |
			// v
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm Booking");
			alert.initStyle(StageStyle.DECORATED);
			alert.setHeaderText("Confirm booking?");
			alert.setContentText(String.format(CONFIRM, cbSubject.getValue().getSurname(), bean.getDate().toString(), bean.getMessage()));
			ButtonType btnAbort = new ButtonType("Back");
			ButtonType btnConfirm = new ButtonType("Confirm");
			alert.getButtonTypes().setAll(btnAbort, btnConfirm);
			Button tmp = (Button) alert.getDialogPane().lookupButton(alert.getButtonTypes().get(0));
			tmp.setPadding(new Insets(10,10,10,10));
			tmp = (Button) alert.getDialogPane().lookupButton(alert.getButtonTypes().get(1));
			tmp.setPadding(new Insets(10,10,10,10));
			Optional<ButtonType> result = alert.showAndWait();
			// ^
			// |
			// ALERT CREATION
			
			if (result.isPresent() && result.get() == btnAbort){
				alert.close();
				abortMeeting(bean);
			} else {
				alert.close();
				stage.close();
				confirmMeeting(bean);
			}
			notifyObservers();
		}
	}

}
