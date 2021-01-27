package logic.control.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.model.bean.LoginBean;
import logic.view.boundary.LoginBoundary;

public class LoginFxControl implements LoginBoundary {

	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private VBox root;
	@FXML
	private TextField tfUsername;
	@FXML
	private PasswordField pfPassword;
	@FXML
	private Button btnLogin;
	
	@FXML
	private void initialize() {
		tfUsername.setText("1");
		pfPassword.setText("GIACOMOJVERDI");
	}
	
	@FXML
	private void onClick() {
		LoginBean bean = new LoginBean(Integer.parseInt(tfUsername.getText()), pfPassword.getText());
		String session = verifyUser(bean);
		if(session != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/WeStudyScene.fxml"));
				Stage appliation = loader.load();
				SceneFxControl controlFx = loader.getController();
				controlFx.setUserSession(session);
				appliation.show();
				this.stage.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
