package logic.control.gui;

import logic.control.SimpleLogger;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.model.Observer;
import logic.view.fx.View;

public class MeetingMenuGuiControl {

	@FXML
	private Parent root;
	@FXML
	private TableColumn<?, String> tbColDate;
	@FXML
	private TableColumn<?, String> tbColSubject;
	@FXML
	private Button btnNewMeeting;
	@FXML
	private Button btnDeleteMeeting;
	@FXML
	private Label lblDate;
	@FXML
	private Label lblTurn;
	@FXML
	private Text txtMessage;
	
	// add DAO reference

	
//	@Override
//	public void setModality() {
//		// it dosen't have stage
//	}

	@FXML
	private void initialize() {
		SimpleLogger.method(this, "initilaize");
	}
	
	@FXML
	private void newMeeting() {
		SimpleLogger.method(this, "newMeeting");
		new View("/CreateMeeting.fxml", new Stage());
	}
	
	@FXML
	private void deleteMeeting() {
		SimpleLogger.method(this, "deleteMeeting");
		// DAO operations
	}
}
