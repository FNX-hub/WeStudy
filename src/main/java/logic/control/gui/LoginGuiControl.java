package logic.control.gui;

import logic.control.SimpleLogger;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.view.fx.View;


public class LoginGuiControl extends GuiControl {
	 
	@FXML
	private Parent root;
	@FXML
	private TextField tfUsername;
	@FXML
	private PasswordField pfPassword;
	@FXML
	private CheckBox cbRemember;
	@FXML
	private Button btnLogin;
	
	@FXML
	public void onClick() {
		SimpleLogger.method(this, "onClick");
		istance.closeStage();
		// TODO add boundary for login
		new View("/ProfessorRoot.fxml", new Stage());
	}

	
	
	@Override
	public void setIstance(View istance) {
		super.setIstance(istance);
		this.istance.getStage().setOnCloseRequest(e->SimpleLogger.info("application closed"));
	}
	
	@Override
	public void setModality() {
		super.setModality();
		istance.getStage().show();	
	}
}
