package testTrani;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import logic.model.ClassCourse;
import logic.model.Grade;
import logic.model.Student;
public class ManageStudentCareerTest {
	
	@Test
	//Inizializza uno studente/studentessa e gli/le assegna una serie di voti
	public void multipleGradeCreation() {
		Student user1 = new Student("PaolinoPaperino","Paolino","Paperino","PP8Password",null);
		List<Grade> studentGrades = new ArrayList<Grade>();
		ClassCourse tempCourse01 = new ClassCourse("Matematica");
		ClassCourse tempCourse02 = new ClassCourse("Letteratura");
		
		studentGrades = user1.getGrades();
		
		//Stampa di Controllo
		System.err.print("[DEBUG]: <TESTING> ");
		System.err.print("(Student: "+ user1.getName() + " " + user1.getSurname() + " )");
		System.err.print("(Grades: ");
		for(int i=0 ; i<studentGrades.size() ; i++) {
			System.err.print("-[" + studentGrades.get(i).getCourse().getSubject() + "/" + studentGrades.get(i).getMark() + "/" + studentGrades.get(i).getDescription() + "]-");
		}
		System.err.println(")");
		
		//Creazione di 2 Grade
		Date todayDate = new Date();
		Grade grade01 = new Grade(tempCourse01,10,todayDate,"Testing Things");
		Grade grade02 = new Grade(tempCourse01,9,todayDate,"Something");
		Grade grade03 = new Grade(tempCourse02,7,todayDate,"");
		
		//Aggiungo quei voti alla carriera dello studente
		user1.addGrade(grade01);
		user1.addGrade(grade02);
		user1.addGrade(grade03);
		
		//Stampa di Controllo
		System.err.print("[DEBUG]: <TESTING> ");
		System.err.print("(Student: "+ user1.getName() + " " + user1.getSurname() + " )");
		System.err.print("(Grades: ");
		for(int i=0 ; i<studentGrades.size() ; i++) {
			System.err.print("-[" + studentGrades.get(i).getCourse().getSubject() + "/" + studentGrades.get(i).getMark() + "/" + studentGrades.get(i).getDescription() + "]-");
		}
		System.err.println(")");
	}
}
