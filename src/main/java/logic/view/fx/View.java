package logic.view.fx;

import logic.control.SimpleLogger;
import logic.control.gui.RootGuiControl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class View {
	
	protected FXMLLoader loader;
	protected Parent rootLayout;
	protected Stage stage;
	
	
	/*
	 *  Constructor 
	 *  @param String fxmlPath: URL of the Layout.fxml resource to load 
	 *  @param  Stage stage: 	Stage to load the layout 
	 */
	public View(String fxmlPath, Stage stage) {
		SimpleLogger.constructor(this);
		this.stage = stage;
		try {
			loader = new FXMLLoader(getClass().getResource(fxmlPath));
			rootLayout = loader.load();
			if (stage != null) {
				stage.setScene(new Scene(rootLayout));				
				RootGuiControl control = loader.getController();
				control.setIstance(this);
				control.setModality();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("A fatal error occurred");
			alert.setContentText("The application will close");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait()
				.filter(response->response==ButtonType.OK)
				.ifPresent(response->System.exit(1));			
		}
	}

	protected FXMLLoader getFxmlLoader() {
		SimpleLogger.method(this, "getFxmlLoader");
		return loader;
	}

	public Parent getRootLayout() {
		SimpleLogger.method(this, "getRootLayout");
		return rootLayout;
	}
	
	public Stage getStage() {
		SimpleLogger.method(this, "getStage");
		return stage;
	}
	
	public Object getControl() {
		SimpleLogger.method(this, "getControl");
		return loader.getController();
	}
	
	public void showStage() {
		SimpleLogger.method(this, "showStage");
		stage.showAndWait();
	}
	
	public void closeStage() {
		SimpleLogger.method(this, "closeStage");
		stage.close();
	}
}
