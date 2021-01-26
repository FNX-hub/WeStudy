package logic.control;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import logic.model.Assignment;
import logic.model.ClassCourse;
import logic.model.OralAssignment;
import logic.model.ProjectAssignment;
import logic.model.WrittenAssignment;
import logic.model.bean.AssignmentBean;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedAssignment;
import logic.model.dao.DaoFactory;

//@author Adriano
public class ManageClassAssignment {
	
	
	//Dato id di un determinato ClassCourse -> restituisci TUTTI i suoi assignment
	public List<ExtendedAssignment> viewClassAssignment(ClassCourseBean bean){
		//Lista di entity Assignment
		List<Assignment> results;
		
		//Chiama la DAO corrispondente ed esegui la query per ottenere gli Assignment
		results = DaoFactory.getAssignmentDao().getCourseAssignment(bean.getCourseId());
		
		//Chiama la DAO corrispondente e chiedi il nome del ClassCourse
		ClassCourse temporaryCourse = new ClassCourse(bean.getCourseId());
		temporaryCourse = DaoFactory.getClassCourseDao().getFromId(bean.getCourseId());
		String courseName = temporaryCourse.getSubject();
		
		//Converti i risultati ottenuti
		List<ExtendedAssignment> convertedResults = new ArrayList<>();
		
		for(int i=0 ; i<results.size() ; i++){
			
			String type = results.get(i).getType();
			String description = results.get(i).getDescription();
			Date creationDate = results.get(i).getCreationDate();
			Date deadlineDate = results.get(i).getDeadlineDate();
			
			ExtendedAssignment assignmentBean = new ExtendedAssignment(type,description, creationDate, deadlineDate, courseName);
			convertedResults.add(assignmentBean);
		}
		
		return convertedResults;
	}
	
	//Dato id di un classCourse -> aggiungi un nuovo assignment
	public void createAssignment(AssignmentBean assignmentBean, ClassCourseBean classCourseBean) {
		
		//Crea assignment con i parametri passati
		Assignment assignment;
		String type = assignmentBean.getType();
		switch(type) {
			case "ORAL":
				assignment = new OralAssignment(type, assignmentBean.getDescription(), assignmentBean.getDeadline());
				break;
			case "WRITTEN":
				assignment = new WrittenAssignment(type, assignmentBean.getDescription(), assignmentBean.getDeadline());
				break;
			case "PROJECT":
				assignment = new ProjectAssignment(type, assignmentBean.getDescription(), assignmentBean.getDeadline());
				break;
			default:
				assignment = null;
				break;
		}
		//Recupera dalla persistenza i dati per inizializzare il ClassCourse a cui correlare l'assignment
		Integer courseId = classCourseBean.getCourseId();
		ClassCourse course = DaoFactory.getClassCourseDao().getFromId(courseId);
		
		//Associa il nuovo assignment al suo classCourse corrispondente
		course.addAssignment(assignment);
		
		//TODO propagazione agli studenti interessati (notifica)
		
		//Chiama il DAO per mettere in persistenza l'assignment creato
		DaoFactory.getAssignmentDao().save(assignment);
	}
}
