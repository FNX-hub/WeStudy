package logic.control.gui;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.model.Observer;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.UserBean;
import logic.view.boundary.ViewStudentCareerStudent;

public class ViewStudentCareerFxControl implements ViewStudentCareerStudent, Observer {

	private UserBean session;
	@FXML
	private SplitPane root;
	@FXML
	private TableView<ExtendedGrade> tvGradeTable;
	@FXML
	private TableColumn<ExtendedGrade, LocalDate> tbColDate;
	@FXML
	private TableColumn<ExtendedGrade, Integer> tbColMark;
	@FXML
	private TableColumn<ExtendedGrade, String> tbColCourse;
	@FXML
	private Button btnNewGrade;
	@FXML
	private Button btnDeleteGrade;
	@FXML
	private Text txtMessage;
	
	private ExtendedGrade selected;
	private ObservableList<ExtendedGrade> beanList; 
	
	
	@FXML
	private void initialize() {
		tbColDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty()); 
		tbColMark.setCellValueFactory(cellData -> cellData.getValue().markProperty().asObject());
		tbColCourse.setCellValueFactory(cellData -> cellData.getValue().coursenameProperty());
		beanList = FXCollections.observableArrayList();
		tvGradeTable.setItems(beanList);
		tvGradeTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showGradeDetails(newValue));
	}
	
	private void showGradeDetails(ExtendedGrade grade) {
		try{
			this.selected = grade;
			txtMessage.setText(grade.getDescription());
		} catch (NullPointerException e) {
			txtMessage.setText("No grade selected");			
		}
	}
	
	@FXML
	private void deleteGrade() {
		if(this.selected != null) {
			beanList.remove(selected);
			selected = null;
		}
		update();
	}

	@FXML
	private void newGrade() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateMeeting.fxml"));
			Stage appliation = loader.load();
			BookMeetingFxControl controlFx = loader.getController();
			controlFx.setUserSession(session);
			controlFx.attach(this);
			appliation.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update() {
		beanList.removeAll(tvGradeTable.getItems());
		beanList.addAll(view(session));
	}

	public UserBean getSession() {
		return session;
	}

	public void setSession(UserBean session) {
		this.session = session;
		update();
	}
}
