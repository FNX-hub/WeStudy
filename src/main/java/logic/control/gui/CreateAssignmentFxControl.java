package logic.control.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.control.SimpleLogger;
import logic.model.Subject;
import logic.model.bean.AssignemntType;
import logic.model.bean.AssignmentBean;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.UserBean;
import logic.model.bean.WrongDeclarationCustomException;
import logic.view.boundary.ManageClassAssignmentProfessor;

public class CreateAssignmentFxControl extends Subject implements ManageClassAssignmentProfessor{

	@FXML
	private Stage root;
	@FXML
	private Scene scene;
	@FXML
	private ComboBox<ClassCourseBean> cbCourse;
	@FXML
	private DatePicker dpDate;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnConfirm;
	@FXML
	private ComboBox<AssignemntType> cbType;
	@FXML
	private TextArea txtarDescription;
	
	
	@FXML
	private void initialize() {
		root.initModality(Modality.APPLICATION_MODAL);
		root.initStyle(StageStyle.DECORATED);
		root.setTitle("Create Assignment");
	}
	
	public void setUserSession(UserBean userSession) {
		cbCourse.setItems(FXCollections.observableArrayList(getAllCourses(userSession)));
		cbType.setItems(FXCollections.observableArrayList(AssignemntType.values()));
	}
	
	@FXML
	private void cancel() {
		root.close();
	}
	
	@FXML
	private void confirm() {
		if(cbCourse.getValue()!= null && cbType != null && !txtarDescription.getText().isBlank()) {
			try {
				SimpleLogger.info("info");
				createAssignment(new AssignmentBean(cbType.getValue().name(), txtarDescription.getText(), dpDate.getValue()), cbCourse.getValue());
				super.notifyObservers();
			} catch (WrongDeclarationCustomException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid information in form");
				alert.initStyle(StageStyle.DECORATED);
				alert.showAndWait();
			}
			root.close();
		}
	}
}
