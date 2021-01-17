package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.Grade;



/* @Author Adriano & Simone */
public class StudentCareerDao implements Dao<Grade> {

	private static final String SELECT =  "SELECT * FROM grade ";
	private static final String SELECT_STUDENT_GRADES = "SELECT * FROM grade WHERE student_id = '%s'";
	
	
	
	//private static final String SELECT_S = "SELECT * FROM grade JOIN course ";
	
	
	@Override
	//RESTITUISCE UN INTERA TABELLA
	public List<Grade> getAll() {

		//Crea una List di Grade vuota
		List<Grade> grades = new ArrayList<Grade>();
		
		//Tenta di connetterti al DB
		try(
				//istanzia una variabile per tentare di connetterti al DB
				Connection conn = DaoConnector.getIstance().getConnection();
				
				//crea uno statement/query da eseguire sul DB
				Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
				
				//esegui la query sul DB e memorizzane i risultati
				ResultSet rs = statement.executeQuery(SELECT)
			){
			//Se il try va a buon fine
			if(!rs.first()) {
				//il DB NON ha restituito qualcosa - returna una List vuota
				return grades;
			}
			do {
				Grade tempGrade = new Grade(rs.getInt("value"),rs.getString("description"));
				grades.add(tempGrade);
			}while(rs.next()); //finchè estrae una tupla, continua ad iterare
			
		}
		catch(SQLException e) {
			//se è stata lanciata un'eccezione di tipo SQLException, oppure un'eccezione is a kind of SQLException
			SimpleLogger.severe("[DEBUG]: " + e.getMessage());
		}
		//qui viene chiuso il canale di comunicazione con il DB e vengono liberate le risorse
		
		//Restituiscimi una lista di Grade
		return grades;
	}

	
	public void dummyTest(String studentName) {
		String.format(SELECT_STUDENT_GRADES,studentName); //sostituisce tutte le stringhe di formato in quella query con ciò che gli passo come parametro
		
		//String.format(SELECT_STUDENT_GRADES,studentName,"Pippo");
	}
	
	@Override
	public void save(Grade t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Grade t, String[] pkeys) {
		// TODO Auto-generated method stub
		t.setDescription(pkeys[0]);
		
	}

	@Override
	public void delete(Grade t) {
		// TODO Auto-generated method stub
		
	}
	
}
