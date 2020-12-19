package logic.control;


import javafx.application.Application;
import javafx.stage.Stage;
import logic.view.fx.View;

public class AppLauncher extends Application {	
	@Override
	public void start(Stage primaryStage) {
		SimpleLogger.method(this, "start");
		new View("/Login.fxml", new Stage());
	}
}
