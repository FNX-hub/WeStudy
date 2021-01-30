package logic.control.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.control.AppLauncher;
import logic.control.SimpleLogger;
import logic.model.bean.UserBean;
import logic.view.boundary.LoginBoundary;

public class SceneFxControl implements LoginBoundary {

	private UserBean userSession;
	@FXML
	protected Stage stage;
	@FXML
	protected Scene scene;
	@FXML
	protected BorderPane sceneRoot;
	@FXML
	protected MenuBar menuBar;
	@FXML
	protected MenuItem menuItemCourse;
	@FXML
	protected MenuItem menuItemGrade;
	@FXML
	protected MenuItem menuItemQuestion;
	@FXML
	protected MenuItem menuItemEvent;
	@FXML
	protected MenuItem menuItemBookings;
	@FXML
	protected MenuItem menuItemSettings;
	@FXML
	protected Parent courseButton;
	@FXML
	protected Parent gradeButton;
	@FXML
	protected Parent questionButton;
	@FXML
	protected Parent eventButton;
	@FXML
	protected Parent bookingButton;
	@FXML
	protected Parent settingButton;
	
	@FXML
	private void initialize() {
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initStyle(StageStyle.DECORATED);
	}
	
	@FXML
	private void openCourses() {
		try {
			stage.setTitle("Courses - Assignments");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Assignements.fxml"));
			sceneRoot.setCenter(loader.load());
			ManageClassAssignmentFxControl controlFx = loader.getController();
			controlFx.setSession(userSession);
		} catch (IOException e) {
			new FatalErrorFx();
		}		
	}
	@FXML
	private void openGrades() {
		try {
			stage.setTitle("Student Career");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Grades.fxml"));
			sceneRoot.setCenter(loader.load());
			ViewStudentCareerFxControl controlFx = loader.getController();
			controlFx.setSession(userSession);
		} catch (IOException e) {
			new FatalErrorFx();
		}		
	}
	@FXML
	private void openBookings() {
		try {
			stage.setTitle("Manage meetings");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MeetingMenu.fxml"));
			sceneRoot.setCenter(loader.load());
			ManageMeetingFxControl controlFx = loader.getController();
			controlFx.setSession(userSession);
			controlFx.update();
		} catch (IOException e) {
			new FatalErrorFx();
		}
	}

	public void setUserSession(UserBean userSession) {
		menuItemQuestion.setVisible(false);
		menuItemEvent.setVisible(false);
		this.userSession = userSession;
		switch(userSession.getType()) {
		case PARENT:
			menuItemCourse.setVisible(false);
			openBookings();
			break;
		case PROFESSOR:
			openBookings();
			break;
		case STUDENT:
			menuItemBookings.setVisible(false);
			openCourses();
			break;
		default:
			break;
		}
	}

	public UserBean getUserSession() {
		return userSession;
	}
	
	@FXML
	private void logout() {
		logout(userSession);
		stage.close();
		new AppLauncher().start(new Stage());
	}
}
