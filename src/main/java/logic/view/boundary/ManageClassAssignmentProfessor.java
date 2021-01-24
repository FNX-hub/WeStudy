package logic.view.boundary;

import logic.control.ManageClassAssignment;
import logic.model.bean.AssignmentBean;
import logic.model.bean.ClassCourseBean;

public class ManageClassAssignmentProfessor {
	
	public void createAssignment(Integer assignmentSubClass,AssignmentBean assignmentBean, ClassCourseBean classCourseBean) {
		//Inizializza il controller corrispondente
		ManageClassAssignment controller = new ManageClassAssignment();
		
		//Esegui il caso d'uso
		controller.createAssignment(assignmentSubClass, assignmentBean, classCourseBean);
	}
	
	
	//TODO
	public void modifyAssignment() {
		
	}
	//TODO forse non sarà necessario ...
	public void deleteAssignment() {
		
	}
	//TODO forse non devo mettere un void ma restituire qualcosa al controller grafico (o alla boundary)
	//Per restituire, in qualche forma, la lista di assignment visibili da questo utente
	public void viewAssignments(String userRole) {
		
	}
	
	//TODO
	public void createClassTest() {
		
	}
	
	//TODO
	public void modifyClassTest() {
		
	}
	//TODO forse non sarà necessario ...
	public void deleteClassTest() {
		
	}
	
	//TODO
	//Per restituire, in qualche forma, la lista di assignment visibili da questo utente
	public void viewTests(String userRole) {
		
	}
}
