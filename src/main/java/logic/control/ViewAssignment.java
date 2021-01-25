package logic.control;

import java.util.List;

import logic.model.ExtendedAssignment;
import logic.model.bean.StudentBean;
import logic.model.dao.DaoFactory;

// @author Adriano
public class ViewAssignment {

	//Visualizza TUTTI gli assignment visibili dallo studente indicato
	public List<ExtendedAssignment> viewAssignmentStudent(StudentBean studentBean) {
		//Inizializza Lista per contenere i risultati
		List<ExtendedAssignment> results;
		
		//Richiedi le informazioni al DAO
		results = DaoFactory.getAssignmentDao().getExtendedStudentAssignment(studentBean.getId());
		
		//Restituisci le informazioni ottenute
		if(results == null) {
			return null;
		}
		else {
			return results;
		}
		
	}
	
}
