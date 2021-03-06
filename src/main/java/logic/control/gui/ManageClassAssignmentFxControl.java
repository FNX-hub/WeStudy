package logic.control.gui;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.control.SimpleLogger;
import logic.model.Observer;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedAssignment;
import logic.model.bean.UserBean;
import logic.model.bean.UserType;
import logic.view.boundary.ManageClassAssignmentProfessor;

public class ManageClassAssignmentFxControl implements ManageClassAssignmentProfessor, Observer{
	
	private UserBean session;
	@FXML
	private BorderPane root;
	@FXML
	private ComboBox<ClassCourseBean> cbCourse;
	@FXML
	private Button btnAddAssignment;
	@FXML
	private TableView<ExtendedAssignment> tvAssignments;
	@FXML
	private TableColumn<ExtendedAssignment, LocalDate> tbColDeadline;
	@FXML
	private TableColumn<ExtendedAssignment, String> tbColType;
	@FXML
	private Text txtDescription;
	
	private ObservableList<ExtendedAssignment> beanList;
	
	private void showAssignemntDetails(ExtendedAssignment assignment) {
		try{
			txtDescription.setText(assignment.getDescription());
		} catch (NullPointerException e) {
			txtDescription.setText("No Assignment selected");			
		}
	}

	@Override
	public void update() {
		beanList.removeAll(tvAssignments.getItems());
		beanList.addAll(viewClassAssignment(cbCourse.getValue()));		
	}
	
	@FXML
	private void newAssignment() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateAssignment.fxml"));
			Stage appliation = loader.load();
			CreateAssignmentFxControl controlFx = loader.getController();
			controlFx.setUserSession(session);
			controlFx.attach(this);
			appliation.show();
		} catch (Exception e) {
			new FatalErrorFx();
		}
	}
	
	public void setSession(UserBean userSession) {
		this.session = userSession;
		if(session.getType().equals(UserType.PROFESSOR)) {
			cbCourse.setItems(FXCollections.observableArrayList(getAllCourses(session)));
		} else {
			cbCourse.setItems(FXCollections.observableArrayList(getStudentCourses(session)));
			btnAddAssignment.setVisible(false);
		}
		tbColDeadline.setCellValueFactory(cellData->cellData.getValue().deadlineProperty());
		tbColType.setCellValueFactory(cellData->cellData.getValue().typeProperty());
		beanList = FXCollections.observableArrayList();
		SimpleLogger.info(beanList.toString());
		tvAssignments.setItems(beanList);
		tvAssignments.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showAssignemntDetails(newValue));
		cbCourse.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> update());
	}
}
