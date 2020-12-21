package logic.control.gui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import logic.view.fx.View;

public class AssignmentsRootGuiControl extends RootGuiControl {

	@FXML 
	private Parent root;
	@FXML 
	private TitledPane tpHomeworks;
	@FXML 
	private VBox vbHomeworks;
	@FXML 
	private TitledPane tpHistory;
	@FXML 
	private VBox vbHistory;

	@Override
	public void setModality() {
		super.setModality();
		istance.getStage().showAndWait();
	}
	
	@FXML
	private void initialize() {
		vbHomeworks.getChildren().add(new View("/Homework.fxml", null).getRootLayout());
		vbHistory.getChildren().add(new View("/Homework.fxml", null).getRootLayout());
		vbHomeworks.getChildren().add(new View("/Homework.fxml", null).getRootLayout());
		vbHistory.getChildren().add(new View("/Homework.fxml", null).getRootLayout());
		vbHomeworks.getChildren().add(new View("/Homework.fxml", null).getRootLayout());
		vbHistory.getChildren().add(new View("/Homework.fxml", null).getRootLayout());
		vbHomeworks.getChildren().add(new View("/Homework.fxml", null).getRootLayout());
		vbHistory.getChildren().add(new View("/Homework.fxml", null).getRootLayout());
	}
}
