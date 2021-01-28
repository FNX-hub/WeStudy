package logic.control.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.model.Subject;
import logic.model.bean.AssignemntType;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.GradeBean;
import logic.model.bean.StudentBean;
import logic.model.bean.WrongDeclarationCustomException;
import logic.view.boundary.ManageClassCourseInformation;

public class CreateGradeFxControl extends Subject implements ManageClassCourseInformation {

	
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private GridPane root;
	@FXML
	private TextArea tarMessage;
	@FXML
	private Button btnNext;
	@FXML
	private Button btnCancel;
	@FXML
	private Label lblCourse;
	@FXML
	private Label lblStudent;
	@FXML
	private Spinner<Integer> sMark;
	@FXML
	private ComboBox<AssignemntType> cbType;

	private ClassCourseBean course;
	private StudentBean student;
	
	public void setParams(ClassCourseBean course, StudentBean student) {
		this.course = course;
		this.lblCourse.setText(course.toString());
		this.student = student;
		this.lblStudent.setText(student.toString());
		this.cbType.setItems(FXCollections.observableArrayList(AssignemntType.values()));
	}
	
	@FXML
	private void confirm() {
		if(!tarMessage.getText().isBlank() && cbType.getValue()!=null) {
			try {
				this.addGrade(new GradeBean(student.getId(), sMark.getValue(), tarMessage.getText(), course.getCourseId(), cbType.getValue().name()));
				super.notifyObservers();
			} catch (WrongDeclarationCustomException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid information in form");
				alert.initStyle(StageStyle.DECORATED);
				alert.showAndWait();
			}
		}
		stage.close();
	}
	@FXML
	private void cancel() {
		stage.close();		
	}

}
