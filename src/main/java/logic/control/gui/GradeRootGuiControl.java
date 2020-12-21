package logic.control.gui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import logic.view.fx.View;

public class GradeRootGuiControl extends RootGuiControl {

	@FXML 
	private Parent root;
	@FXML 
	private FlowPane fpGradeContainer;
	@FXML 
	private Label lblAvarage;

	@Override
	public void setModality() {
		super.setModality();
		istance.getStage().showAndWait();
	}
	
	@FXML
	private void initialize() {
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
		fpGradeContainer.getChildren().add(new View("/Grade.fxml", null).getRootLayout());
	}
}
