package logic.control.gui;

import javafx.stage.Modality;
import javafx.stage.StageStyle;
import logic.control.SimpleLogger;
import logic.model.Observer;
import logic.view.fx.View;

public abstract class RootGuiControl implements Observer {
	
	protected View istance;

	public View getIstance() {
		SimpleLogger.method(this, "getIstance");
		return istance;
	}

	public void setIstance(View istance) {
		SimpleLogger.method(this, "setIstance");
		this.istance = istance;
	}
	
	public void setModality() {
		SimpleLogger.method(this, "setModality");
		istance.getStage().setResizable(false);
		istance.getStage().initModality(Modality.APPLICATION_MODAL);
		istance.getStage().initStyle(StageStyle.DECORATED);
	}
}