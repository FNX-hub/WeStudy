package logic.control.gui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import logic.control.SimpleLogger;
import logic.model.Observer;
import logic.view.fx.View;

public class QuestionRootGuiControl implements Observer {

	@FXML
	private Parent root;
	@FXML
	private TableColumn<String, ?> tcClasses;
	@FXML
	private VBox vbMessageContainer;
	@FXML
	private TextArea txtarMessage;
	@FXML
	private Button btnSend;
	
	@FXML
	private void initialize() {
		vbMessageContainer.getChildren().add(new View("/ChatMessageA.fxml", null).getRootLayout());
	}
	
	@FXML
	private void send() {
		SimpleLogger.method(this, "send");
		vbMessageContainer.getChildren().add(new View("/ChatMessageB.fxml", null).getRootLayout());
	}
}
