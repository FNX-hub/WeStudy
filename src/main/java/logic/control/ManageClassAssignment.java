package logic.control;

import java.time.LocalDate;
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
//Estensione necessaria: utilizza metodi comuni ad un altro controller di un altro caso d'uso
public class ManageClassAssignment extends RecoverClassCourseInformation{
	
	
	//Dato id di un determinato ClassCourse -> restituisci TUTTI i suoi assignment
	public List<ExtendedAssignment> viewClassAssignment(ClassCourseBean bean){
		//Converti i risultati ottenuti
		List<ExtendedAssignment> convertedResults = new ArrayList<>();
		//Chiama la DAO corrispondente ed esegui la query per ottenere gli Assignment
		try {
			List<Assignment> results = DaoFactory.getAssignmentDao().getCourseAssignment(bean.getCourseId());
			
			//Chiama la DAO corrispondente e chiedi il nome del ClassCourse
			ClassCourse temporaryCourse = new ClassCourse(bean.getCourseId());
			temporaryCourse = DaoFactory.getClassCourseDao().getFromId(bean.getCourseId());
			String courseName = temporaryCourse.getSubject();
			
			SimpleLogger.info("DEBUG: "+ courseName);
			
			
			for(int i=0 ; i<results.size() ; i++){
				
				String type = results.get(i).getType();
				String description = results.get(i).getDescription();
				LocalDate creationDate = results.get(i).getCreationDate();
				LocalDate deadlineDate = results.get(i).getDeadlineDate();
				
				ExtendedAssignment assignmentBean = new ExtendedAssignment(type,description, creationDate, deadlineDate, courseName);
				convertedResults.add(assignmentBean);
			}
		}
		catch(NullPointerException e) {
			SimpleLogger.info("La query ha restituito 0 valori");
		}
		
		return convertedResults;
	}
	
	//Dato id di un classCourse -> aggiungi un nuovo assignment
	public void createAssignment(AssignmentBean assignmentBean, ClassCourseBean classCourseBean){
		
		//Crea assignment con i parametri passati
		Assignment assignment;
		String type = assignmentBean.getType();
		
		SimpleLogger.info("DEBUG: createAssignment -> TYPE: <"+type+">");
		
		switch(type) {
			case "ORAL":
				SimpleLogger.info("DEBUG: created ORAL Assignment");
				assignment = new OralAssignment(type, assignmentBean.getDescription(), assignmentBean.getDeadline());
				break;
			case "WRITTEN":
				SimpleLogger.info("DEBUG: created WRITTEN Assignment");
				assignment = new WrittenAssignment(type, assignmentBean.getDescription(), assignmentBean.getDeadline());
				break;
			case "PROJECT":
				SimpleLogger.info("DEBUG: created PROJECT Assignment");
				assignment = new ProjectAssignment(type, assignmentBean.getDescription(), assignmentBean.getDeadline());
				break;
			default:
				assignment = null;
				break;
		}

		SimpleLogger.info("DEBUG: created Assignment: " + assignment.getDescription() + "|" + assignment.getType() +  "|" + assignment.getCreationDate() +  "|" + assignment.getDeadlineDate());
		
		Integer courseId = classCourseBean.getCourseId();
	
		//Chiama il DAO per mettere in persistenza l'assignment creato
		DaoFactory.getAssignmentDao().save(assignment,courseId);
	}
}
