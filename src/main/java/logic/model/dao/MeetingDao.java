package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.Meeting;


/**
 * @author Simone
 */
public class MeetingDao implements Dao<Meeting> {
	
	// Name columns table
	
	private static final String PARENT = "parent_id";
	private static final String PROFESSOR = "professor_id";
	private static final String DATE= "date";
	private static final String MESSAGE= "message";
	
	// SQL statements
	
	private static final String SELECT = "SELECT * FROM meeting";
	private static final String SELECT_BY_ID = "SELECT * FROM meeting WHERE parent_id = '%s' OR professor_id = '%s'";
	private static final String INSERT = "INSERT INTO meeting VALUES (%s,'%s','%s', '%s')";
	private static final String UPDATE = "UPDATE meeting SET parent_id = '%s', professor_id = '%s', message = '%s', date = '%s' WHERE parent_id = '%s' AND professor_id = '%s' AND date = '%s'";
	private static final String DELETE = "DELETE FROM meeting WHERE parent_id = '%s' AND professor_id = '%s' AND date = '%s'";

	// Error message
	
	private static final String ERROR = "Unable to execute %s: %s";
	
	@Override
	public List<Meeting> getAll() {
		List<Meeting> listMeeting = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(SELECT)
			)
		{
			if(!rs.first()) {
				return listMeeting;
			}
			do {
				Meeting m = new Meeting(rs.getString(PARENT), rs.getString(PROFESSOR), rs.getString(DATE), rs.getString(MESSAGE));
				listMeeting.add(m);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT, e.getMessage()));
		}
		return listMeeting;
	}
	public List<Meeting> getFromUser(String userName) {
		String s = String.format(SELECT_BY_ID, userName, userName);
		List<Meeting> listMeeting = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(s)
			)
		{
			if(!rs.first()) {
				return listMeeting;
			}
			do {
				Meeting m = new Meeting(rs.getString(PARENT), rs.getString(PROFESSOR), rs.getString(DATE), rs.getString(MESSAGE));
				listMeeting.add(m);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT, e.getMessage()));
		}
		return listMeeting;
	}

	// CRUD operation
	@Override
	public void save(Meeting t) {
		String s = String.format(INSERT, t.getParentId(), t.getProfessorId(), t.getDate(), t.getMessage());
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(s);
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		}		
	}
	@Override
	public void update(Meeting t, String[] pkeys) {
		if(pkeys.length != 3) throw new IllegalArgumentException("Number of params must be 3");
		String s = String.format(UPDATE, t.getParentId(), t.getProfessorId(), t.getDate(), pkeys[0], pkeys[1], pkeys[2]);
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(s);
		}
		catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		} catch (IllegalArgumentException e2) {
			SimpleLogger.severe(e2.getMessage());
		}
	}
	@Override
	public void delete(Meeting t) {
		String s = String.format(DELETE, t.getParentId(), t.getProfessorId(), t.getDate());
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(s);
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		}
	}
}
