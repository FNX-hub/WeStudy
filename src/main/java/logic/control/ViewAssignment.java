package logic.control;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import logic.model.Assignment;
import logic.model.ClassCourse;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedAssignment;
import logic.model.bean.UserBean;
import logic.model.dao.DaoFactory;

// @author Adriano
public class ViewAssignment implements RecoverClassCourseInformation{

	//Funzione di supporto
	//Dato uno specifico classCourse & uno specifico studente -> visualizza TUTTI gli assignment in quel classCourse
	public List<ExtendedAssignment> viewAssignmentStudentCourse(UserBean studentBean, ClassCourseBean courseBean){
		List<ExtendedAssignment> convertedResults = new ArrayList<>();
		
		//Richiedi gli assignment di quel classCourse
		List<Assignment> results;
		results = DaoFactory.getAssignmentDao().getCourseAssignment(courseBean.getCourseId());
		
		//Richiedi il nome di quel classCourse
		ClassCourse extractedCourse = DaoFactory.getClassCourseDao().getFromId(courseBean.getCourseId());
		String courseName = extractedCourse.getSubject();
		
		//Aggiungi alla lista di bean TUTTI gli Assignment di quel classCourse
		for(int i=0 ; i<results.size() ; i++) {
			String type = results.get(i).getType();
			String description = results.get(i).getDescription();
			Date creationDate = results.get(i).getCreationDate();
			Date deadlineDate = results.get(i).getDeadlineDate();
			
			//istanzia il bean ed aggiungilo alla lista
			ExtendedAssignment extendedAssignment = new ExtendedAssignment(type,description,creationDate, deadlineDate,courseName);
			convertedResults.add(extendedAssignment);
		}
		
		return convertedResults;
	}
	
	
	//Visualizza TUTTI gli assignment visibili dallo studente indicato
	public List<ExtendedAssignment> viewAssignmentStudent(UserBean studentBean) {
		List<ExtendedAssignment> convertedResults = new ArrayList<>();
				
		//Richiedi al DAO TUTTI i codici id di TUTTI i classCourse di cui lo studente con questo id fa parte
		List<ClassCourse> allCourses = DaoFactory.getClassCourseDao().getFromStudentId(studentBean.getId());
		
		SimpleLogger.info("DEBUG: numero di corsi trovati: " + allCourses.size());
		
		//Per ogni id del classCourse ottenuto -> richiedi alla DAO la lista di Assignment corrispondenti
		for(int i=0 ; i<allCourses.size() ; i++) {
			Integer courseId = allCourses.get(i).getId();
			SimpleLogger.info("DEBUG: (" + i + ") id corso: " + courseId);
			
			//richiedi gli assignment di quel classCourse
			try {
				List<Assignment> results = DaoFactory.getAssignmentDao().getCourseAssignment(courseId);
				
				//Richiedi il nome di quel classCourse
				ClassCourse extractedCourse = DaoFactory.getClassCourseDao().getFromId(courseId);
				String courseName = extractedCourse.getSubject();
				
				SimpleLogger.info("DEBUG: (" + i + ") nome corso: " + courseName);
				
				SimpleLogger.info("DEBUG: (" + i + ") numero di assignment: " + results.size());
				
				//Aggiungi alla lista di bean TUTTI gli Assignment di quel classCourse
				for(int j=0 ; j<results.size() ; j++) {
					String type = results.get(j).getType();
					String description = results.get(j).getDescription();
					Date creationDate = results.get(j).getCreationDate();
					Date deadlineDate = results.get(j).getDeadlineDate();
					
					//istanzia il bean ed aggiungilo alla lista
					ExtendedAssignment extendedAssignment = new ExtendedAssignment(type,description,creationDate, deadlineDate,courseName);
					convertedResults.add(extendedAssignment);
				}
			}
			catch(NullPointerException e) {
				SimpleLogger.info("DEBUG: (" + i + ") Catturata eccezione");
				SimpleLogger.info("DEBUG: (" + i + ") numero di assignment: 0");
			}

		}
		return convertedResults;
	}
	
}
