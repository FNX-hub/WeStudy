package logic.view.boundary;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import logic.control.ManageStudentCareer;
import logic.control.SimpleLogger;
import logic.model.ExtendedGrade;
import logic.model.Grade;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.GradeBean;
import logic.model.bean.UserBean;

public class ManageStudentCareerProfessor {
	
	
	public void addGrade(GradeBean gradeBean, ClassCourseBean classCourseBean, UserBean studentBean) {
		//Inizializza il controller per l'esecuzione del caso d'uso
		ManageStudentCareer controller = new ManageStudentCareer();
		
		//esegui il caso d'uso
		controller.addGrade(gradeBean, classCourseBean, studentBean);
	}
	
	
	//Restituisci tutti i voti di questo corso - versione estesa
	public List<String> viewExtendedClassCourseGrades(ClassCourseBean classCourseBean){
		//Dati da returnare in un formalismo adeguato alla grafica (diverso da quello delle entity)
		List<String> convertedResults = new ArrayList<String>();
		
		//Dati effettivamente returnati dal controller applicativo
		List<ExtendedGrade> results;
		
		//Inizializza il controller per l'esecuzione del caso d'uso
		ManageStudentCareer controller = new ManageStudentCareer();
				
		//Esegui il caso d'uso
		results = controller.viewExtendedClassCourseGrades(classCourseBean);
		
		try {
			//Converti le informazioni in un formato  adeguato alla grafica
			ExtendedGrade extractedGrade;
			Integer extractedMark;
			String extractedType;
			String extractedDescription;
			String extractedStudentName;
			String extractedStudentSurname;
			Date extractedDate;
			
			for(int i=0 ; i<results.size() ; i++) {
				extractedGrade = results.get(i);
				
				//Estrai le informazioni
				extractedStudentName = extractedGrade.getStudentName();
				extractedStudentSurname = extractedGrade.getStudentSurname();
				extractedMark = extractedGrade.getMark();
				extractedType = extractedGrade.getType();
				extractedDescription = extractedGrade.getDescription();
				extractedDate = extractedGrade.getDatabaseDate();
				
				//Inseriscile all'interno della lista - tutte nella forma di stringhe
				convertedResults.add(extractedStudentName);
				convertedResults.add(extractedStudentSurname);
				convertedResults.add(extractedMark.toString());
				convertedResults.add(extractedType);
				convertedResults.add(extractedDescription);
				convertedResults.add(extractedDate.toString());
			}
		}
		//SE la query NON ha restituito nulla
		//	entra in logica di errore
		catch(NullPointerException e) {
			SimpleLogger.info("NullPointerException caught");
			convertedResults.add("Every");
			convertedResults.add("student");
			convertedResults.add("in this");
			convertedResults.add("classCourse");
			convertedResults.add("does not have");
			convertedResults.add("a grade");
		}
		
		//Returna le informazioni convertite
		return convertedResults;
	}
	
	
	//Restituisci tutti i voti di questo corso
	public List<String> viewClassCourseGrades(ClassCourseBean classCourseBean){
		//Dati da returnare in un formalismo adeguato alla grafica (diverso da quello delle entity)
		List<String> convertedResults = new ArrayList<String>();
		
		//Dati effettivamente returnati dal controller applicativo
		List<Grade> results;
		
		//Inizializza il controller per l'esecuzione del caso d'uso
		ManageStudentCareer controller = new ManageStudentCareer();
				
		//Esegui il caso d'uso
		results = controller.viewClassCourseGrades(classCourseBean);
		
		//Converti le informazioni in un formato  adeguato alla grafica
		Grade extractedGrade;
		Integer extractedMark;
		String extractedType;
		String extractedDescription;
		
		
		for(int i=0 ; i<results.size() ; i++) {
			extractedGrade = results.get(i);
			
			//Estrai le informazioni
			extractedMark = extractedGrade.getMark();
			extractedType = extractedGrade.getType();
			extractedDescription = extractedGrade.getDescription();
			
			
			//Inseriscile all'interno della lista - tutte nella forma di stringhe
			convertedResults.add(extractedMark.toString());
			convertedResults.add(extractedType);
			convertedResults.add(extractedDescription);
			
		}
		
		//Returna le informazioni convertite
		return convertedResults;
	}
}
