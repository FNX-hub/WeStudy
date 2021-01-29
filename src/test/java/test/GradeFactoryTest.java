package test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

import logic.control.SimpleLogger;
import logic.model.ClassCourse;
import logic.model.Grade;

//@author Adriano
public class GradeFactoryTest {
	
	@Test
	public void createGrade() {
		
		//Parametri attesi
		Integer expectedMark = 10;
		String expectedDescription = "Verifica sui polinomi";
		String expectedType = "WRITTEN";
		String expectedCourseName = "Matematica";
		Integer expectedCourseId = 39;
		Date expectedDate = Date.valueOf(LocalDate.now());
		
		//Variabili di controllo
		Integer expectedValue = 6;
		Integer actualValue = 0;
		
		//Stampe di controllo
		SimpleLogger.info("DELIVERABLE: TEST CON JUNIT > expected values");
		SimpleLogger.info(" >>> expectedMark: " + expectedMark );
		SimpleLogger.info(" >>> expectedDescription: " + expectedDescription );
		SimpleLogger.info(" >>> expectedType: " + expectedType );
		SimpleLogger.info(" >>> expectedCourseName: " + expectedCourseName );
		SimpleLogger.info(" >>> expectedCourseId: " + expectedCourseId );
		SimpleLogger.info(" >>> expectedDate: " + expectedDate);
		
		//Inizializzazione
		ClassCourse testCourse = new ClassCourse(expectedCourseName,expectedCourseId);
		Grade testGrade = new Grade(testCourse,expectedMark,expectedDescription,expectedType);
		
		//Valori effettivi
		Integer actualMark = testGrade.getMark(); 
		String actualDescription = testGrade.getDescription();
		String actualType = testGrade.getType();
		String actualCourseName = testCourse.getSubject();
		Integer actualCourseId = testCourse.getId();
		Date actualDate = testGrade.getDate();
		
		//Stampe di controllo
		SimpleLogger.info("DELIVERABLE: TEST CON JUNIT > actual values");
		SimpleLogger.info(" >>> actualMark: " + actualMark );
		SimpleLogger.info(" >>> actualDescription: " + actualDescription );
		SimpleLogger.info(" >>> actualType: " + actualType );
		SimpleLogger.info(" >>> actualCourseName: " + actualCourseName );
		SimpleLogger.info(" >>> actualCourseId: " + actualCourseId );
		SimpleLogger.info(" >>> actualDate: " + actualDate);
		
		//Controlli
		if(actualMark.equals(expectedMark)){
			actualValue++;
		}
		if(actualDescription.equals(expectedDescription)){
			actualValue++;
		}
		if(actualType.equals(expectedType)){
			actualValue++;
		}
		if(actualCourseName.equals(expectedCourseName)){
			actualValue++;
		}
		if(actualCourseId.equals(expectedCourseId)){
			actualValue++;
		}
		if(actualDate.equals(expectedDate)){
			actualValue++;
		}
		
		//Controlli
		assertEquals(expectedValue, actualValue);
	}
}

