package logic.model;

import java.util.Date;

//Classe la cui unica responsabilità è essere un Creator per Grade
public class GradeFactory {
	
	public GradeFactory() {
		System.err.println("[DEBUG]: GradeFactory creata con successo");
	}
	
	
	public Grade createGrade(Integer mark, String description, String type) {
		Grade grade = new Grade(mark,description,type);
		return grade;
	}
	
	/*
	//forse inutile
	public Grade createGrade(Integer classCourseId, Integer mark, String description) {
		ClassCourse tempClassCourse = new ClassCourse(classCourseId);
		Grade createdGrade = Grade(tempClassCourse);
		return createdGrade;
	}
	*/
	/*
	public Grade createGrade(ClassCourse course,Integer mark,String description){
		Date todayDate = new Date();
		Grade newGrade = new Grade(course,mark,todayDate,description);
		return newGrade;
	}
	*/
}