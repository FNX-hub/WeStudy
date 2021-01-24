package logic.model;


import logic.control.SimpleLogger;

//@author Adriano
//Classe la cui unica responsabilità è essere un Creator per Grade
public class GradeFactory {
	
	public GradeFactory() {
		SimpleLogger.info("GradeFactory costruttore");
	}
	
	public Grade createGrade(Integer mark, String description, String type) {
		return new Grade(mark,description,type);
	}
}