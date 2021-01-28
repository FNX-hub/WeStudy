package logic.control;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import logic.control.gui.FatalErrorFx;

public class AppLauncher extends Application {	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
			Stage root = loader.load();
			root.show();
		} catch (Exception e) {
			new FatalErrorFx();
		}
	}
}
