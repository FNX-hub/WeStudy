package logic.view.boundary;

import java.util.List;

import logic.control.ManageStudentCareer;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.GradeBean;
public interface ManageStudentCareerProfessor extends RecoverCourseInformation {
	
	
	//Dato un Grade, un id del ClassCourse e un id di uno Student ()-> Aggiungi a quello Student quel Grade
	//NB questo metodo NON controlla se tale studente fa parte di quel corso, la responsabilita' e' assegnata al chiamante
	public default void addGrade(GradeBean gradeBean) {
		//Inizializza il controller per l'esecuzione del caso d'uso
		ManageStudentCareer controller = new ManageStudentCareer();
		
		//esegui il caso d'uso
		controller.addGrade(gradeBean);
	}
	
	
	//Restituisci TUTTI i voti di questo corso
	public default List<ExtendedGrade> viewExtendedClassCourseGrades(ClassCourseBean classCourseBean){
		ManageStudentCareer controller = new ManageStudentCareer();
		return controller.viewClassCourseGrades(classCourseBean);
	}
}
