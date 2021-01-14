package logic.control;

import logic.model.ClassCourse;
import logic.model.Grade;
import logic.model.GradeFactory;
import logic.model.Student;


//TODO controllare la logica del caso d'uso
//TODO realizzare le boundary corrispondenti
public class ManageStudentCareer {
	
	public void addGrade(ClassCourse course,Integer mark,String description,Student selectedStudent) {
		//Crea il Grade utilizzando la GradeFactory
		GradeFactory tempGradeFactory = new GradeFactory();
		Grade newGrade = tempGradeFactory.createGrade(course,mark,description);
		
		//Associa tale Grade allo studente corrispondente
		selectedStudent.addGrade(newGrade);
	}
}
