package logic.control;

import java.util.List;

import logic.model.ExtendedAssignment;
import logic.model.bean.StudentBean;
import logic.model.dao.DaoFactory;

public class ViewAssignment {

	public List<ExtendedAssignment> viewAssignmentStudent(StudentBean studentBean) {
		//Inizializza Lista per contenere i risultati
		List<ExtendedAssignment> results;
		
		//Richiedi le informazioni al DAO
		results = DaoFactory.getAssignmentDao().getStudentAssignment(studentBean.getId());
		
		//Restituisci le informazioni ottenute
		return results;
	}
	
}
