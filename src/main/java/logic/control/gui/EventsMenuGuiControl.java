package logic.control.gui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import logic.control.SimpleLogger;
import logic.model.Observer;
import logic.view.fx.View;

public class EventsMenuGuiControl {

	@FXML
	private Parent root;
	@FXML
	private VBox vbEventsContainer;
	@FXML
	private Label lblNoEvents;
	
	@FXML
	private void initialize() {
		SimpleLogger.method(this, "initialize");
		vbEventsContainer.getChildren().remove(0);
		vbEventsContainer.getChildren().add(new View("/Event.fxml", null).getRootLayout());
		vbEventsContainer.getChildren().add(new View("/Event.fxml", null).getRootLayout());
		vbEventsContainer.getChildren().add(new View("/Event.fxml", null).getRootLayout());
		vbEventsContainer.getChildren().add(new View("/Event.fxml", null).getRootLayout());
	}
}
