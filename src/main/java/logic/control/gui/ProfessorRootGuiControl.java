package logic.control.gui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.control.AppLauncher;
import logic.control.SimpleLogger;
import logic.view.fx.View;

public class ProfessorRootGuiControl extends RootGuiControl {

	private static final String MEETINGMENU = "/MeetingMenu.fxml"; 
	
	@FXML
	private BorderPane root;
	@FXML
	private Label mClasses;
	@FXML
	private Label mQuestions;
	@FXML
	private Label mEvents;
	@FXML
	private MenuItem mitmAllMeetings;
	@FXML
	private MenuItem mitmNewMeeting;
	@FXML
	private Label mLogout;
	
	@Override
	public void setModality() {
		super.setModality();
		istance.getStage().setOnCloseRequest(e->this.logout());
		istance.getStage().show();
	}
		
	@FXML
	private void initialize() {
		SimpleLogger.method(this, "initialize");
		setScene(MEETINGMENU);
	}
	

	private Parent setScene(String arg) {
		SimpleLogger.method(this, "setScene");
		Parent node = new View(arg, null).getRootLayout();
		root.setCenter(node);
		return node;
	}
	

	/*
	 * Class related methods	
	 */
	@FXML
	private void seeClasses() {
		SimpleLogger.method(this, "seeClasses");
		setScene("/ClassesMenu.fxml");
	}
	
	/*
	 * Question related methods	
	 */
	@FXML
	private void seeQuestions() {
		SimpleLogger.method(this, "seeQuestion");
		setScene("/QuestionsRoot.fxml");
	}
	
	/*
	 * Events related methods	
	 */
	@FXML
	private void seeEvents() {
		SimpleLogger.method(this, "seeEvents");
		setScene("/EventsMenu.fxml");
	}
	
	/*
	 * Meeting relate methods	
	 */
	@FXML
	private void allMeetings() {
		SimpleLogger.method(this, "allMeetings");
		setScene(MEETINGMENU);
	}
	
	@FXML
	private void newMeeting() {
		SimpleLogger.method(this, "allMeetings");
		setScene(MEETINGMENU);
		new View("/CreateMeeting.fxml", new Stage());
	}
	
	/*
	 * Logout
	 */
	@FXML
	private void logout() {
		SimpleLogger.method(this, "logout");
		istance.closeStage();
		new AppLauncher().start(new Stage());
	}
}
