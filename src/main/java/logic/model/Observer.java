package logic.model;

import logic.control.SimpleLogger;

public interface Observer {
	public default void update() {
		SimpleLogger.method(this, "update");
	}
}
