package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.Parent;

public class ParentDao implements Dao<Parent> {

	// Name columns table
	
	private static final String ID = "id";
	private static final String SURNAME = "surname";
	private static final String NAME = "name";
	private static final String PASSWORD = "password";
	//TODO use in QUERY get* and update 
	private static final String PHONE = "phone_number";
	
	// SQL statements
	
	private static final String SELECT = "SELECT * FROM parent";
	private static final String SELECT_BY_ID = "SELECT * FROM parent WHERE id = '%s'";
	private static final String INSERT = "INSERT INTO parent VALUES ('%s','%s','%s', '%s')";
	private static final String UPDATE = "UPDATE parent SET id = '%s', surname = '%s', name = '%s', password = '%s' WHERE id = '%s'";
	private static final String DELETE = "DELETE FROM parent WHERE id = '%s'";
	
	// Error message
	
	private static final String ERROR = "Unable to execute %s: %s";
				
	@Override
	public List<Parent> getAll() {
		List<Parent> listParent = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(SELECT)
			)
		{
			if(!rs.first()) {
				return listParent;
			}
			do {
				Parent p = new Parent(rs.getString(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD));
				listParent.add(p);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT, e.getMessage()));
		}
		return listParent;
	}
	public Parent getFromId(String id) {
		String s = String.format(SELECT_BY_ID, id);
		Parent p = null;
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(s)
			)
		{
			if(!rs.first()) {
				return p;
			}
			 p = new Parent(rs.getString(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD));
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		}
		return p;
	}
	
	
	// CRUD operation
	
	@Override
	public void save(Parent t) {
		String s = String.format(INSERT, t.getId(), t.getSurname(), t.getName(), t.getPassword());
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(s);
			SimpleLogger.info(String.format("Insert: %s", t.toString()));
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		}		
	}
	@Override
	public void update(Parent t, String[] params) {
		if(params.length != 1) throw new IllegalArgumentException("Number of params must be 1");
		String s = String.format(UPDATE, t.getId(), t.getSurname(), t.getName(), t.getPassword(), params[0]);
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(s);
			SimpleLogger.info(String.format("Update: %s", t.toString()));
		}
		catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		} catch (IllegalArgumentException e2) {
			SimpleLogger.severe(e2.getMessage());
		}
	}
	@Override
	public void delete(Parent t) {
		String s = String.format(DELETE, t.getId());
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(s);
			SimpleLogger.info(String.format("Delete: %s", t.toString()));
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		}
	}
}
