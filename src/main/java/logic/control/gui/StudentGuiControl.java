package logic.control.gui;

import logic.control.AppLauncher;
import logic.control.SimpleLogger;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import logic.model.Observer;
import logic.view.fx.View;

public class StudentGuiControl implements Observer {

	@FXML
	BorderPane root;
	@FXML
	Menu mAssignments;
	@FXML
	Menu mGrades;
	@FXML
	MenuItem mitmSeeQuestions;
	@FXML
	MenuItem mitmNewQuestion;
	@FXML
	Menu mEvents;
	@FXML
	Menu mLogout;
	
	public StudentGuiControl() {
		SimpleLogger.constructor(this);
	}
	
	@FXML
	private void initialize() {
		SimpleLogger.method(this, "initialize");
		setScene("/AssignmentMenuStudent.fxml");
	}
	
	private Parent setScene(String arg) {
		SimpleLogger.method(this, "setScene");
		Parent node = new View(arg, null).getRootLayout();
		root.setCenter(node);
		return node;
	}
	
	/*
	 * Assignments related methods	
	 */
	@FXML
	private void seeAssignment() {
		SimpleLogger.method(this, "seeAssignment");
		mAssignments.addEventHandler(Menu.ON_SHOWN, event -> mAssignments.hide());
		mAssignments.addEventHandler(Menu.ON_SHOWING, event -> mAssignments.fire());
	}
	
	/*
	 * Grade related methods	
	 */
	@FXML
	private void seeGrades() {
		SimpleLogger.method(this, "seeAssignment");
		mGrades.addEventHandler(Menu.ON_SHOWN, event -> mGrades.hide());
		mGrades.addEventHandler(Menu.ON_SHOWING, event -> mGrades.fire());
	}
	
	/*
	 * Question related methods	
	 */
	@FXML
	private void seeQuestions() {
		SimpleLogger.method(this, "seeQuestion");
	}
	@FXML
	private void newQuestion() {
		SimpleLogger.method(this, "newQuestion");
	}
	
	/*
	 * Events related methods	
	 */
	@FXML
	private void seeEvents() {
		SimpleLogger.method(this, "seeEvents");
		mEvents.addEventHandler(Menu.ON_SHOWN, event -> mEvents.hide());
		mEvents.addEventHandler(Menu.ON_SHOWING, event -> mEvents.fire());
	}
	
	/*
	 * Logout
	 */
	@FXML
	private void logout() {
		SimpleLogger.method(this, "logout");
		mLogout.addEventHandler(Menu.ON_SHOWN, event -> mLogout.hide());
		mLogout.addEventHandler(Menu.ON_SHOWING, event -> mLogout.fire());	
		Window window = root.getScene().getWindow();
		window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
		new AppLauncher().start(new Stage());
	}
}
