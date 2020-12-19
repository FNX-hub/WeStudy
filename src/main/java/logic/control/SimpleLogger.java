package logic.control;

import java.util.logging.Logger;

public class SimpleLogger {
	
	private static final String CONSTRUCTOR = "Called %s.Contructor()";
	private static final String METHOD = "Called %s.%s()";
	
	private SimpleLogger() {
		
	}
	public static void info(String msg) {
		Logger.getAnonymousLogger().info(msg);
	}
	public static void constructor(Object obj) {
		String s = String.format(CONSTRUCTOR, obj.getClass().getName());
		Logger.getAnonymousLogger().info(s);
	}
	public static void method(Object obj, String mthd) {
		String s = String.format(METHOD, obj.getClass().getName(), mthd);
		Logger.getAnonymousLogger().info(s);
	}
	public static void warning(String msg) {
		Logger.getAnonymousLogger().warning(msg);
	}
	public static void severe(String msg) {
		Logger.getAnonymousLogger().severe(msg);
	}
}
