package logic.view.boundary;

import java.util.List;

import logic.control.ManageStudentCareer;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.GradeBean;
import logic.model.bean.UserBean;

public class ManageStudentCareerProfessor {
	
	//Aggiungi un voto ad uno student
	public void addGrade(GradeBean gradeBean, ClassCourseBean classCourseBean, UserBean studentBean) {
		//Inizializza il controller per l'esecuzione del caso d'uso
		ManageStudentCareer controller = new ManageStudentCareer();
		
		//esegui il caso d'uso
		controller.addGrade(gradeBean, classCourseBean, studentBean);
	}
	
	
	//Restituisci tutti i voti di questo corso
	public List<ExtendedGrade> viewExtendedClassCourseGrades(ClassCourseBean classCourseBean){
		ManageStudentCareer controller = new ManageStudentCareer();
		return controller.viewClassCourseGrades(classCourseBean);
	}
}
