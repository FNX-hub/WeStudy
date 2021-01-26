package logic.model;


import logic.control.SimpleLogger;

//@author Adriano
//Per evitare di assegnare eccessiva responsabilità al controller del caso d'uso
//Questa classe svolge il ruolo di Creator per Grade
public class GradeFactory {
	
	public GradeFactory() {
		SimpleLogger.info("GradeFactory costruttore");
	}
	
	public Grade createGrade(Integer mark, String description, String type) {
		return new Grade(mark,description,type);
	}
}