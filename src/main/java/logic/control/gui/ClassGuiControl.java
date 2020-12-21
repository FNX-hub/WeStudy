package logic.control.gui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import logic.control.SimpleLogger;
import logic.model.Observer;
import logic.view.fx.View;

public class ClassGuiControl implements Observer {

	@FXML
	private Parent root;
	@FXML
	private Label lblClass;
	@FXML
	private Button btnAssignments;
	@FXML
	private Button btnGrades;
	
	public void setClass(String name) {
		SimpleLogger.method(this, "setName");
		lblClass.setText(name);
	}
	
	@FXML
	public void seeAssignments() {
		SimpleLogger.method(this, "seeAssignemnts");
		new View("/AssignementsRoot.fxml", new Stage());
	}
	@FXML
	public void seeGrades() {
		SimpleLogger.method(this, "seeGrades");
		new View("/GradeRoot.fxml", new Stage());
	}
}
