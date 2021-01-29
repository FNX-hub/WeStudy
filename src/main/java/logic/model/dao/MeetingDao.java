package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
	
	private static final String SELECT_ALL = "SELECT * FROM meeting";
	private static final String SELECT_BY_PARENT = "SELECT * FROM meeting WHERE parent_id = '%d'";
	private static final String SELECT_BY_PROFESSOR = "SELECT * FROM meeting WHERE professor_id = '%d'";
	private static final String INSERT = "INSERT INTO meeting VALUES ('%d','%d','%s','%s')";
	private static final String UPDATE = "UPDATE meeting SET parent_id = '%d', professor_id = '%d', message = '%s', date = '%s' WHERE parent_id = '%s' AND professor_id = '%s' AND date = '%s'";
	private static final String DELETE = "DELETE FROM meeting WHERE parent_id = '%s' AND professor_id = '%s' AND date = '%s'";

	// Error message
	
	private static final String ERROR = "Unable to execute %s: %s";
	
	@Override
	public List<Meeting> getAll() {
		List<Meeting> listMeeting = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(SELECT_ALL)
			)
		{
			if(!rs.first()) {
				return listMeeting;
			}
			do {
				Meeting m = new Meeting(rs.getInt(PARENT), rs.getInt(PROFESSOR), LocalDate.parse(rs.getDate(DATE).toString()), rs.getString(MESSAGE));
				listMeeting.add(m);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_ALL, e.getMessage()));
		}
		return listMeeting;
	}
	public List<Meeting> getFromParent(Integer userId) {
		String query = String.format(SELECT_BY_PARENT, userId);
		List<Meeting> listMeeting = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				return listMeeting;
			}
			do {
				Meeting m = new Meeting(rs.getInt(PARENT), rs.getInt(PROFESSOR), LocalDate.parse(rs.getDate(DATE).toString()), rs.getString(MESSAGE));
				listMeeting.add(m);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_ALL, e.getMessage()));
		}
		return listMeeting;
	}
	public List<Meeting> getFromProfessor(Integer userId) {
		String query = String.format(SELECT_BY_PROFESSOR, userId);
		List<Meeting> listMeeting = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
				)
		{
			if(!rs.first()) {
				return listMeeting;
			}
			do {
				Meeting m = new Meeting(rs.getInt(PARENT), rs.getInt(PROFESSOR), LocalDate.parse(rs.getDate(DATE).toString()), rs.getString(MESSAGE));
				listMeeting.add(m);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_ALL, e.getMessage()));
		}
		return listMeeting;
	}

	// CRUD operation
	@Override
	public void save(Meeting t) {
		String query = String.format(INSERT, t.getParentId(), t.getProfessorId(), t.getDate().toString(), t.getMessage());
		executeUpdate(query,ERROR);
	}
	
	@Override
	public void update(Meeting t, String[] pkeys) {
		String query = String.format(UPDATE, t.getParentId(), t.getProfessorId(), t.getDate().toString(), pkeys[0], pkeys[1], pkeys[2]);
		executeUpdate(query,ERROR);
	}
	@Override
	public void delete(Meeting t) {
		String query = String.format(DELETE, t.getParentId(), t.getProfessorId(), t.getDate().toString());
		
		executeUpdate(query,ERROR);
		
	}
}