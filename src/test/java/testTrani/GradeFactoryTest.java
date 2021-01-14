package testTrani;

import org.junit.Test;

import logic.model.ClassCourse;
import logic.model.Grade;
import logic.model.GradeFactory;

public class GradeFactoryTest {
	
	@Test
	public void GradeFactory_createGrade_01() {
		
		int expetedMark = 10;
		String expetedDescription = "Voto preso perchè si";
		Grade testGrade;
		
		//Istanzia la Factory dei Grade
		GradeFactory tempFactory = new GradeFactory();
		ClassCourse tempCourse = new ClassCourse("Matematica");

		//Crea un grade
		testGrade = tempFactory.createGrade(tempCourse, expetedMark , expetedDescription );
		
		//Stampa di controllo
		System.err.print("DEBUG: <TESTING> (Created Date:");
		System.err.print(" - Day: " + testGrade.getDate().getDate());
		System.err.print(" - Month: " + testGrade.getDate().getMonth());
		System.err.print(" - Year: " + testGrade.getDate().getYear());
		System.err.println(")");
		
		//Tutti i controlli necessari
		
		
		//Testa se tutti i campi sono stati inizializzati correttamente
		//(fai la somma)
		
	}
	
	
}

