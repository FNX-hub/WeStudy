package logic.model;

import java.util.Date;

//Classe la cui unica responsabilità è essere un Creator per Grade
public class GradeFactory {
	
	public GradeFactory() {
		System.err.println("[DEBUG]: GradeFactory creata con successo");
	}
	
	public Grade createGrade(ClassCourse course,Integer mark,String description ){
		Date todayDate = new Date();
		
		/*
		try {}
		per controllare la correttezza della data???
		catch();
		*/
		
		Grade newGrade = new Grade(course,mark,todayDate,description);
		return newGrade;
	}
}