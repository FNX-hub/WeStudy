package logic.view.boundary;

import java.util.ArrayList;
import java.util.List;

import logic.control.ManageClassAssignment;
import logic.control.SimpleLogger;
import logic.model.ClassCourse;
import logic.model.ExtendedAssignment;
import logic.model.bean.AssignmentBean;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.UserBean;
import logic.model.dao.DaoFactory;

//@author Adriano
public class ManageClassAssignmentProfessor {
	
	//TODO eventualmente utilizza UserBean fatto da Simone
	//Visualizza le informazioni sui classCourse di cui si occupa questo docente
	public List<String> getClassCourses(UserBean bean){

		//TODO una boundary che chiama la DAO? Non è un caso d'uso coplesso, è solo una semplice operazione
		//per motivi di efficienza ho scelto questa implementazione
		//Istanzia direttamente la DAO
		List<ClassCourse> courses = DaoFactory.getClassCourseDao().getFromProfessorId(bean.getId());
		
		//Prepara una lista con i risultati convertiti
		List<String> convertedCourses = new ArrayList<>();
		try {
				//Converti i risultati ricevuti
				for(int i=0 ; i<courses.size() ; i++) {
					String courseId = courses.get(i).getId().toString();
					String courseName = courses.get(i).getSubject();
					convertedCourses.add(courseId);
					convertedCourses.add(courseName);
				}
		}
		//SE la query NON ha restituito nulla
		//	entra in logica di errore
		catch(NullPointerException e)
    	{
			//Crea un'unica tupla contenente una frase esplicativa
			SimpleLogger.info("NullPointerException caught");
			convertedCourses.add("0");
			convertedCourses.add("No courses");
    	}
		return convertedCourses;
	}
	
	public void createAssignment(Integer assignmentSubClass,AssignmentBean assignmentBean, ClassCourseBean classCourseBean) {
		//Inizializza il controller corrispondente
		ManageClassAssignment controller = new ManageClassAssignment();
		
		//Esegui il caso d'uso
		controller.createAssignment(assignmentSubClass, assignmentBean, classCourseBean);
	}
	
	
	public List<String> viewAssignments(ClassCourseBean courseBean) {
		//Liste utilizzate
				List<String> convertedResults = new ArrayList<>();
				List<ExtendedAssignment> results;
				
				//Istanzia il controller applicativo
				ManageClassAssignment controller = new ManageClassAssignment();
				
				//Esegui il caso d'uso e recupera i risultati
				results = controller.viewClassAssignment(courseBean);
				
				
				try {
						//Converti i risultati
						for(int i=0 ; i<results.size() ; i++) {
							convertedResults.add(results.get(i).getType());
							convertedResults.add(results.get(i).getDescription());
							convertedResults.add(results.get(i).getCreationDate().toString());
							convertedResults.add(results.get(i).getDeadlineDate().toString());
						}
					}
					//SE la query NON ha restituito nulla
					//	entra in logica di errore
					catch(NullPointerException e)
		        	{
						//Crea un'unica tupla contenente una frase esplicativa
						SimpleLogger.info("NullPointerException caught");
						convertedResults.add("There");
						convertedResults.add("are");
						convertedResults.add("0");
						convertedResults.add("Assignment");
		        	}
				
				//Restituisci i risultati convertiti alla grafica
				return convertedResults;
	}
	
}
