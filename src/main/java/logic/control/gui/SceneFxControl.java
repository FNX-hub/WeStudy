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
import logic.model.bean.Session;
import logic.model.bean.UserBean;

public class SceneFxControl {

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
	protected MenuItem menuItemEvents;
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
			sceneRoot.setCenter(new FXMLLoader(getClass().getResource("/ChatMessageB.fxml")).load());
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	@FXML
	private void openGrades() {
		try {
			sceneRoot.setCenter(new FXMLLoader(getClass().getResource("/ChatMessageB.fxml")).load());
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	@FXML
	private void openQuestions() {
		try {
			sceneRoot.setCenter(new FXMLLoader(getClass().getResource("/ChatMessageA.fxml")).load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void openEvents() {
		try {
			sceneRoot.setCenter(new FXMLLoader(getClass().getResource("/ChatMessageA.fxml")).load());
		} catch (IOException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}

	public void setUserSession(String sessionId) {
		this.userSession = Session.getIstance().getSessionById(sessionId);
		switch(userSession.getType()) {
		case PARENT:
			menuItemQuestion.setVisible(false);
			menuItemCourse.setVisible(false);
			openBookings();
			break;
		case PROFESSOR:
			openBookings();
			break;
		case STUDENT:
			menuItemBookings.setVisible(false);
			break;
		default:
			break;
		}
	}

	public UserBean getUserSession() {
		return userSession;
	}

}
