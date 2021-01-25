package logic.control;


import java.util.List;

import logic.model.ExtendedGrade;
import logic.model.Grade;
import logic.model.GradeFactory;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.GradeBean;
import logic.model.bean.UserBean;
import logic.model.dao.DaoFactory;


public class ManageStudentCareer{
	
	//Aggiungi un certo voto ad uno studente in un certo course
	public void addGrade(GradeBean gradeBean, ClassCourseBean classCourseBean, UserBean studentBean) {
		//Inizializza una factory per Grade
		GradeFactory factory = new GradeFactory();
		
		//Inizializza i parametri per la creazione del Grade
		Integer value = gradeBean.getGrade();
		String description = gradeBean.getDescription();
		String type = gradeBean.getType();
		
		//Inizializza i parametri non correlati all' entità Grade ma necessari per riempire il DB
		Integer studentId = studentBean.getId();
		Integer courseId = classCourseBean.getCourseId();
		
		//Chiedi di istanziare un Grade con i parametri ricevuti
		Grade grade = factory.createGrade(value, description, type);
			
		//Istanzia una DAO e memorizza lì il Grade appena creato
		DaoFactory.getGradeDao().save(grade,studentId,courseId);
	}
	
	//restituisci tutti i voti assegnati all'interno del course
	public List<Grade> viewClassCourseGrades(ClassCourseBean classCourseBean){
		//Risultato sottoforma di Lista di Entity
		List<Grade> courseGrades;
		
		//Parametri necessari da passare al DAO
		Integer courseId = classCourseBean.getCourseId();
		
		//Inizializza un DAO per effettuare la query e prenderne i risultati
		courseGrades = DaoFactory.getGradeDao().getCourseGrades(courseId);
		
		//Returna al chiamante il risultato ottenuto
		//NB la Boundary avrà la responsabilità di riceverlo e convertirlo in un formato adeguato alla GUI
		return courseGrades;
	}

	//restituisci tutti i voti assegnati all'interno del course - versione estesa
	public List<ExtendedGrade> viewExtendedClassCourseGrades(ClassCourseBean classCourseBean) {
		//Risultato sottoforma di Lista di Entity
				List<ExtendedGrade> courseGrades;
				
				//Parametri necessari da passare al DAO
				Integer courseId = classCourseBean.getCourseId();
				
				//Inizializza un DAO per effettuare la query e prenderne i risultati
				courseGrades = DaoFactory.getGradeDao().getExtendedCourseGrades(courseId);
				
				//Returna al chiamante il risultato ottenuto
				//NB la Boundary avrà la responsabilità di riceverlo e convertirlo in un formato adeguato alla GUI
				return courseGrades;
	}

}
