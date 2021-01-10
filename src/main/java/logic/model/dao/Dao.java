package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import logic.control.SimpleLogger;


/**
 * @author Simone
 */
public interface Dao {
		
	/** 
	 * Try to attempt a query and transform the given SQL table in Java Object or rise an {@link SQLExeption}
	 * @param sqlString String 
	 * @return {@link List}<{@link HashMap} {@code <SQL_column_name><value>}> or an empty {@link List}
	 */ 	
	public default List<HashMap<String,String>> sqlToJava(String sqlString) {
		
		List<HashMap<String, String>> l = new ArrayList<>();
		Connection c = ConnectorDao.getIstance().getConnection();		
		try (	Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sqlString) )
		{	
			while(rs.next()) {
				HashMap<String, String> hm = new HashMap<>();
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					hm.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
				}
				l.add(hm);
			}
		} catch (SQLException e) {
			SimpleLogger.warning("Unable to execute query");
			e.printStackTrace();
		}
		return l;
	}

}