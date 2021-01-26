package logic.control;

import java.util.List;

import logic.model.Assignment;
import logic.model.ExtendedAssignment;
import logic.model.bean.UserBean;
import logic.model.dao.DaoFactory;

// @author Adriano
public class ViewAssignment {

	//Visualizza TUTTI gli assignment visibili dallo studente indicato
	public List<ExtendedAssignment> viewAssignmentStudent(UserBean studentBean) {
		
		
		entity = DaoFactory.getAssignmentDao().getAll();
		
		
		//Inizializza Lista per contenere i risultati
		List<ExtendedAssignment> results;
		
		//Richiedi le informazioni al DAO
		results = DaoFactory.getAssignmentDao().getExtendedStudentAssignment(studentBean.getId());  
		
		
		
		return results;

		
	}
	
}
