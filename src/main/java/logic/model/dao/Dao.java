package logic.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import logic.control.SimpleLogger;


/**
 * @author Simone
 */
public interface Dao<T> {
	
	public List<T>getAll();
	
	public void save(T t);
	
	public void update(T t, String[] pkeys);
	
	public void delete(T t);
	
	public default void executeUpdate(String query, String error) {
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(query);

		} catch (SQLException e) {
			SimpleLogger.severe(String.format(error, query, e.getMessage()));
		}
	}
}