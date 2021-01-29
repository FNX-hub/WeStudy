package logic.control.gui;

import java.time.LocalDate;
import java.util.List;

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
import logic.model.Observer;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.StudentBean;
import logic.model.bean.UserBean;
import logic.model.bean.UserType;
import logic.view.boundary.ManageClassCourseInformation;

public class ViewStudentCareerFxControl implements ManageClassCourseInformation, Observer {

	private UserBean session;
	@FXML
	private BorderPane root;
	@FXML
	private Button btnNewGrade;
	@FXML
	private Button btnSearch;
	@FXML
	private ComboBox<ClassCourseBean> cbCourse; 
	@FXML
	private ComboBox<StudentBean> cbStudent; 
	@FXML
	private TableView<ExtendedGrade> tvGrades;
	@FXML
	private TableColumn<ExtendedGrade, LocalDate> tbColDate;
	@FXML
	private TableColumn<ExtendedGrade, Integer> tbColMark;
	@FXML
	private Text txtDescription;
	
	private ObservableList<ExtendedGrade> beanList; 
	
	
	private void showGradeDetails(ExtendedGrade grade) {
		try{
			txtDescription.setText(grade.getDescription());
		} catch (NullPointerException e) {
			txtDescription.setText("No grade selected");			
		}
	}
	
	@FXML
	private void getGrade() {
		if(cbCourse.getValue() != null && (session.getType().equals(UserType.STUDENT) || cbStudent.getValue()!= null)) {
			update();
		}
	}

	@FXML
	private void newGrade() {
		try {
			if(cbCourse.getValue() != null && cbStudent.getValue()!=null) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateGrade.fxml"));
				Stage appliation = loader.load();
				CreateGradeFxControl controlFx = loader.getController();
				controlFx.setParams(cbCourse.getValue(), cbStudent.getValue());
				controlFx.attach(this);
				appliation.show();
			}
		} catch (Exception e) {
			new FatalErrorFx();
		}			
	}
	
	@Override
	public void update() {
		beanList.removeAll(tvGrades.getItems());
		if(session.getType().equals(UserType.STUDENT)) {
			List<ExtendedGrade> list = getStudentGrades(session);
			list.forEach(grade-> {
				if(grade.getCoursename().equals(cbCourse.getValue().getSubject())) {
					beanList.add(grade);
				}
			});			
		} else {
			List<ExtendedGrade> list = getStudentGrades(cbStudent.getValue());
			list.forEach(grade-> {
				if(grade.getCoursename().equals(cbCourse.getValue().getSubject())) {
					beanList.add(grade);
				}
			});		
		}
	}

	public UserBean getSession() {
		return session;
	}

	public void setSession(UserBean session) {
		this.session = session;
		switch(session.getType()) {
		case PARENT:
			btnNewGrade.setVisible(false);
			cbStudent.setItems(FXCollections.observableArrayList(getAllChildren(session)));
			cbStudent.getSelectionModel().selectedItemProperty().addListener(
					(observable, oldValue, newValue) -> {
						ObservableList<ClassCourseBean> beans = FXCollections.observableArrayList(this.getStudentCourses(newValue));
						cbCourse.setItems(beans);
					});
			break;
		case PROFESSOR:
			cbCourse.setItems(FXCollections.observableArrayList(getProfessorCourses(session)));
			cbCourse.getSelectionModel().selectedItemProperty().addListener(
					(observable, oldValue, newValue) -> {
						ObservableList<StudentBean> beans = FXCollections.observableArrayList(this.getStudentsByCourse(newValue));
						cbStudent.setItems(beans);
					});
			break;
		case STUDENT:
			cbCourse.setItems(FXCollections.observableArrayList(getStudentCourses(session)));
			cbStudent.setVisible(false);
			btnNewGrade.setVisible(false);
			break;
		default:
			break;		
		}
		tbColDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty()); 
		tbColMark.setCellValueFactory(cellData -> cellData.getValue().markProperty().asObject());
		beanList = FXCollections.observableArrayList();
		tvGrades.setItems(beanList);
		tvGrades.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showGradeDetails(newValue));
	}
}
