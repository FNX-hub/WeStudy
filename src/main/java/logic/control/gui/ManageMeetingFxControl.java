package logic.control.gui;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.model.Observer;
import logic.model.bean.MeetingBean;
import logic.model.bean.UserBean;
import logic.model.bean.UserType;
import logic.view.boundary.ManageMeetingBoundary;

public class ManageMeetingFxControl implements ManageMeetingBoundary, Observer {

	
	private UserBean session;
	@FXML
	private SplitPane root;
	@FXML
	private TableView<MeetingBean> tvMeetingTable;
	@FXML
	private TableColumn<MeetingBean, LocalDate> tbColDate;
	@FXML
	private TableColumn<MeetingBean, String> tbColSurname;
	@FXML
	private Button btnNewMeeting;
	@FXML
	private Button btnDeleteMeeting;
	@FXML
	private Text txtMessage;
	
	private MeetingBean selected;
	private ObservableList<MeetingBean> beanList;
	
	private void showMeetingDetails(MeetingBean meeting) {
		try{
			this.selected = meeting;
			txtMessage.setText(meeting.getMessage());
		} catch (NullPointerException e) {
			txtMessage.setText("No meeting selected");			
		}
	}
	
	@FXML
	private void deleteMeeting() {
		if(this.selected != null) {
			deleteMeeting(selected);
			beanList.remove(selected);
			selected = null;
		}
		update();
	}

	@FXML
	private void bookMeeting() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateMeeting.fxml"));
			Stage appliation = loader.load();
			BookMeetingFxControl controlFx = loader.getController();
			controlFx.setUserSession(session);
			controlFx.attach(this);
			appliation.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update() {
		beanList.removeAll(tvMeetingTable.getItems());
		beanList.addAll(getMeetings(session));
	}

	public UserBean getSession() {
		return session;
	}

	public void setSession(UserBean session) {
		this.session = session;
		tbColDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty()); 
		if(session.getType().equals(UserType.PARENT)) {
			tbColSurname.setText("Professor");
			tbColSurname.setCellValueFactory(cellData -> cellData.getValue().professorSurnameProperty());
		}
		else {
			tbColSurname.setText("Parent");
			tbColSurname.setCellValueFactory(cellData -> cellData.getValue().parentSurnameProperty());
		}
		beanList = FXCollections.observableArrayList();
		tvMeetingTable.setItems(beanList);
		tvMeetingTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showMeetingDetails(newValue));
	}
}
