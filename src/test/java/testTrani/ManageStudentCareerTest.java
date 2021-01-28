package testTrani;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import logic.control.ManageStudentCareer;
import logic.control.SimpleLogger;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.StudentBean;

public class ManageStudentCareerTest {
	
	
//	@Test
//	//SIMULA ESECUZIONE COMPLETA
//	//Dato id del classCourse -> restituisci i suoi studenti
//	public void viewClassStudentsTest() {
//		//Valori di controllo
//		Integer expectedNumOfStudents = 0;
//		Integer actualNumOfStudents;
//		
//		//Variabili iniziali
//		ClassCourseBean course = new ClassCourseBean(1998);
//		
//		//Esecuzione del caso d'uso
//		ManageStudentCareer controller = new ManageStudentCareer();
//		List<StudentBean> students = controller.viewClassCourseStudents(course);
//		
//		//Stampa di controllo
//		for(int i=0 ; i<students.size() ; i++) {
//			SimpleLogger.info("STUDENT:" + students.get(i).getId().toString() + "/" + students.get(i).getName() + "/" + students.get(i).getSurname());
//		}
//	
//		//Controllo
//		actualNumOfStudents = students.size();
//		assertEquals(expectedNumOfStudents,actualNumOfStudents);
//	}
	
	@Test
	//SIMULA ESECUZIONE COMPLETA
	//Dato id del classCourse -> restituisci i suoi grade
	public void viewClassGradeTest() {
		//Variabili di controllo
		Integer ActualNumOfGrades;
		Integer ExpectedNumOfGrades = 0;
		
		
		
		//Richiedi un ClassCourse non esistente
		ClassCourseBean courseBean = new ClassCourseBean(1998);
		
		//Eseguo il caso d'uso
		ManageStudentCareer controller = new ManageStudentCareer();
		List<ExtendedGrade> grades = controller.viewClassCourseGrades(courseBean);
		
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
