package testTrani;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import logic.control.SimpleLogger;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedGrade;
import logic.view.boundary.ManageStudentCareerProfessor;

public class ManageStudentCareerTest {
	
	@Test
	public void viewClassGradeTest() {
		//Variabili di controllo
		Integer ActualNumOfGrades;
		Integer ExpectedNumOfGrades = 0;
		
		//Eseguo il caso d'uso
		ManageStudentCareerProfessor boundary = new ManageStudentCareerProfessor();
		//Richiedi un ClassCourse non esistente
		ClassCourseBean courseBean = new ClassCourseBean(2);
		List<ExtendedGrade> grades = boundary.viewExtendedClassCourseGrades(courseBean);
		
		//Stampa di controllo
		for(int i=0 ; i<grades.size() ; i++) {
			SimpleLogger.info(grades.get(i).getStudentName());
			SimpleLogger.info(grades.get(i).getStudentSurname());
			SimpleLogger.info(grades.get(i).getDescription());
			SimpleLogger.info(grades.get(i).dateProperty().toString());
			SimpleLogger.info(grades.get(i).getMark().toString());
		}
		
		//Controlla quanti risultati hai ottenuto
		ActualNumOfGrades = grades.size();
		
		assertEquals(ExpectedNumOfGrades,ActualNumOfGrades);
	}
}
