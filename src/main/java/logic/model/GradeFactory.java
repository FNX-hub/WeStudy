package logic.model;

import java.util.Date;

import logic.control.SimpleLogger;

//@author Adriano
//Classe la cui unica responsabilità è essere un Creator per Grade
public class GradeFactory {
	
	
	public Grade createGrade(Integer mark, String description, String type) {
		Grade grade = new Grade(mark,description,type);
		return grade;
	}
}