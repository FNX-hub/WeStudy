package logic.control.gui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import logic.control.SimpleLogger;
import logic.model.Observer;

public class ChatMessageGuiControl  {

	@FXML
	private Parent root;
	@FXML
	private Label lblName;
	@FXML
	private Text txtMessage;
	
	public void setName(String name) {
		SimpleLogger.method(this, "setName");
		lblName.setText(name);
	}
	
	public void setMessage(String name) {
		SimpleLogger.method(this, "setMessage");
		txtMessage.setText(name);
	}
}
