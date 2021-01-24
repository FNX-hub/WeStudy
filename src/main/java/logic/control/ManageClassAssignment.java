package logic.control;

import logic.model.Assignment;
import logic.model.AssignmentFactory;
import logic.model.ClassCourse;
import logic.model.ClassCourseFactory;
import logic.model.bean.AssignmentBean;
import logic.model.bean.ClassCourseBean;
import logic.model.dao.DaoFactory;

//@author Adriano
public class ManageClassAssignment {
	
	
	public void createAssignment(Integer assignmentType, AssignmentBean assignmentBean, ClassCourseBean classCourseBean) {
		
		//Crea assignment con i parametri passati
		AssignmentFactory assignmentFactory = new AssignmentFactory();
		Assignment assignment = assignmentFactory.createAssignment(assignmentType,assignmentBean);
		
		//Recupera dalla persistenza i dati per inizializzare il ClassCourse a cui correlare l'assignment
		Integer courseId = classCourseBean.getCourseId();
		ClassCourse course = DaoFactory.getClassCourseDao().getFromId(classCourseBean.getCourseId());
		
		//Associa il nuovo assignment al suo classCourse corrispondente
		//TODO propagazione agli studenti interessati e notifica
		course.addAssignment(assignment);
		
		
		//Chiama il DAO per mettere in persistenza l'assignment creato
		DaoFactory.getAssignmentDao().save(assignment);
	}
}
