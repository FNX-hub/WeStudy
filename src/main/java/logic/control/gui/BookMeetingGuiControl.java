package logic.control.gui;

import java.util.Optional;

import logic.control.SimpleLogger;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.StageStyle;

public class BookMeetingGuiControl extends GuiControl {

	@FXML
	private Parent root;
	@FXML
	private Label lblSubject;
	@FXML
	private ComboBox<?> cbSubject;
	@FXML
	private DatePicker dpDate;
	@FXML
	private RadioButton rbTurn1;
	@FXML
	private RadioButton rbTurn2;
	@FXML
	private TextArea tarMessage;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnNext;
	
	@Override
	public void setModality() {
		super.setModality();
		istance.showStage();
	}

	@FXML
	private void initialize() {
		SimpleLogger.method(this, "initialize");
	}
	
	@FXML
	public void next() {
		SimpleLogger.method(this, "next");
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm Booking");
		alert.initStyle(StageStyle.DECORATED);
		alert.setHeaderText(null);
		alert.setContentText("Are you ok with this?");
		ButtonType btnAbort = new ButtonType("Back");
		ButtonType btnConfirm = new ButtonType("Confirm");
		alert.getButtonTypes().setAll(btnAbort, btnConfirm);
		Button tmp = (Button) alert.getDialogPane().lookupButton(alert.getButtonTypes().get(0));
		tmp.setPadding(new Insets(10,10,10,10));
		tmp = (Button) alert.getDialogPane().lookupButton(alert.getButtonTypes().get(1));
		tmp.setPadding(new Insets(10,10,10,10));
		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() && result.get() == btnAbort){
		    alert.close();
		} else {
			alert.close();
			istance.closeStage();
		}
	}
	
	@FXML
	public void cancel() {
		SimpleLogger.method(this, "cancel");
		istance.closeStage();
	}
	
	@FXML
	public void confirm() {
		SimpleLogger.method(this, "confirm");
	}
}
