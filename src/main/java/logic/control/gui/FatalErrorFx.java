package logic.control.gui;

import javafx.scene.control.Alert;

public class FatalErrorFx extends Alert {

	public FatalErrorFx() {
		super(AlertType.ERROR);
		this.setHeaderText("Fatal Error");
		this.setContentText("A fatal error occurred application will stop");
		this.setOnCloseRequest(event-> System.exit(1));
		this.showAndWait();
	}
	
}
