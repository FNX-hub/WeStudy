package logic.control.gui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import logic.model.Observer;
import logic.view.fx.View;

public class ClassMenuGuiControl {

	@FXML
	private Parent root;
	@FXML
	private FlowPane fpClassContainer;
	
	@FXML
	private void initialize() {
		fpClassContainer.getChildren().add(new View("/Class.fxml", null).getRootLayout());
		fpClassContainer.getChildren().add(new View("/Class.fxml", null).getRootLayout());
	}
}
