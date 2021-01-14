package logic.control.gui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import logic.model.Observer;

public class EventGuiControl {

	@FXML
	private Label lblEventName;
	@FXML
	private Label lblDate;
	@FXML
	private Text txtMessage;
	
	@FXML
	private void initialize() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		lblDate.setText(dtf.format(now));
		txtMessage.setText("This is a foo message");
	}
	
	public void setEventName(String name) {
		lblEventName.setText(name);
	}
	public void setEventDate(String name) {
		lblDate.setText(name);
	}
	public void setEventMessage(String name) {
		txtMessage.setText(name);
	}
}
