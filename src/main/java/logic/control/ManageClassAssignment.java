package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.model.Assignment;
import logic.model.AssignmentFactory;
import logic.model.ClassCourse;
import logic.model.ExtendedAssignment;
import logic.model.bean.AssignmentBean;
import logic.model.bean.ClassCourseBean;
import logic.model.dao.DaoFactory;

//@author Adriano
public class ManageClassAssignment {
	
	//Restituisci tutti gli assignment di un determinato classCourse
	public List<ExtendedAssignment> viewClassAssignment(ClassCourse classcourseBean){
		//Inizializza lista per i risultati
		List<ExtendedAssignment> results = new ArrayList<ExtendedAssignment>();
		
		//Istanzia DAO e memorizza i risultati della query
		results = DaoFactory.getAssignmentDao().getCourseAssignment(classcourseBean.getId());
		
		//Restituisci i risultati ottenuti
		return results;
	}
	
	public void createAssignment(Integer assignmentType, AssignmentBean assignmentBean, ClassCourseBean classCourseBean) {
		
		//Crea assignment con i parametri passati
		AssignmentFactory assignmentFactory = new AssignmentFactory();
		Assignment assignment = assignmentFactory.createAssignment(assignmentType,assignmentBean);
		
		//Recupera dalla persistenza i dati per inizializzare il ClassCourse a cui correlare l'assignment
		Integer courseId = classCourseBean.getCourseId();
		ClassCourse course = DaoFactory.getClassCourseDao().getFromId(courseId);
		
		//Associa il nuovo assignment al suo classCourse corrispondente
		course.addAssignment(assignment);
		
		//TODO propagazione agli studenti interessati e notifica
		
		
		//Chiama il DAO per mettere in persistenza l'assignment creato
		DaoFactory.getAssignmentDao().save(assignment);
	}
}
