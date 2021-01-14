package logic.model.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import logic.control.SimpleLogger;



/**
 * Singleton class with the responsibility to create the connection with the DB 
 * @author Simone
 */
public class DaoConnector {

	private Connection connection;
	private static final DaoConnector istance = new DaoConnector();
	
	private DaoConnector() {
		connect();
	}
	
	public static DaoConnector getIstance() {
		return istance;
	}
	
	/**
	 * Attempts to establish a connection to the application database.
	 * The connection specks are in the configuration file {@code db_setting}.
	 * <p>
	 * If the file is missing or rise an {@link IOExeption}.
	 * If the connection fail rise an {@link SQLExeption}
	 */
	private void connect() {
		Path path = Paths.get("db_setting");
		String url = null;
		String user = null;
		String password = null;
	    try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8))
		    {
	    		url = reader.readLine();
	    		user = reader.readLine();
	    		password = reader.readLine();
		    }
	    catch (IOException io)
		    {
	    		SimpleLogger.severe("Error in file \"db_seting\": is missing or corrupted");
	    	}  
	    try 
		   { 
    			this.connection = DriverManager.getConnection(url, user, password);
    			SimpleLogger.info(String.format("Connected to %s", url));
		   }
	    catch (SQLException sql)
		   {
	    		SimpleLogger.severe("Unable to connect to DB");		   
		   }
	}
	
	public Connection getConnection() {
		try {
			if(connection.isClosed()) connect();
		} catch (SQLException e) {
			SimpleLogger.severe("Unable to verify connection to DB");			
		}
		return connection;
	}
}
