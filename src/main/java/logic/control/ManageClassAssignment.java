package logic.control;

import logic.model.Assignment;
import logic.model.bean.ClassCourseBean;

public class ManageClassAssignment {
	
	
	public void createAssignment(Integer assignmentType, ClassCourseBean classCourseBean) {
		
		//Crea assignment con i parametri passati
		AssignmentFactory factory = new AssignmentFactory();
		Assignment assignment = factory.createAssignment(assignmentType);
		
		//TODO Controlla se il classCourse passato come parametro è realmente esistente
		
		
		//Chiama il DAO per mettere in persistenza assignment creato
		
	}
}
