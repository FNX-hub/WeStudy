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
	}
	
	public static DaoConnector getIstance() { 
		return istance;
	}
	
	/**
	 * Attempts to establish a connection to the application database.
	 * The connection specks are in the configuration file {@code db_setting}: 
	 * <li> {@code db_url}
	 * <li> {@code username}
	 * <li> {@code password}   
	 * @throws IOException if the configuration file {@code db_setting} is corrupted or missing.
	 * @throws SQLException if a database access error occurs or {@code db_setting} is wrongly set
	 */
	private void connect() throws SQLException {
		Path path = Paths.get("db_setting");
		String url = null;
		String user = null;
		String password = null;
		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8))
		{
			url = reader.readLine();
			user = reader.readLine();
			password = reader.readLine();
			if(url==null || user==null || password==null) throw new IOException();
			if(url.isBlank() || user.isBlank() || password.isBlank()) throw new IOException();
		} catch (IOException e) {
			SimpleLogger.severe(e.getMessage());
			url = "jdbc:mysql://localhost/westudy";
			user = password = "application";
		}
		try {
			this.connection = DriverManager.getConnection(url, user, password);			
		}
		catch (SQLException sql) {
			System.exit(1);
		}
	}
	
	public Connection getConnection() throws SQLException {
		if(connection == null || connection.isClosed()) connect();
		return connection;
	}
}
