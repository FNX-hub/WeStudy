package homeworkTrani;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.control.SimpleLogger;
import logic.model.Assignment;
import logic.model.ExtendedAssignment;
import logic.model.Homework;
import logic.model.dao.DaoFactory;

//@author Adriano
public class AssignmentCreationTestDB {
	
	
	public AssignmentCreationTestDB(){
		SimpleLogger.info("<<<TEST-JUNIT>>>");
	}
	
	@Test
	public void insertAndRead() {
		/*
		//Crea delle entità fittizie da inserire
		String expectedType = "ORAL";
		String expectedDescription = "Inserito tramite JUNIT Test";
		LocalDate currentDate = LocalDate.now();
		Date expectedDate = Date.valueOf(currentDate);
		Assignment assignment01 = new Homework(expectedType,expectedDescription);
		
		assignment01.setDeadlineDate(expectedDate);
		Integer classCourseId = 1;
		
		//Variabili per assert
		Integer numOfMatchings = 0;
		Integer expectedMatchings = 1;
		
		//Inizializza direttamente la DAO e inserisci nel database
		DaoFactory.getAssignmentDao().save(assignment01, classCourseId);
		
		//Recupera dal database tutte le tuple
		List<ExtendedAssignment> results = new ArrayList<>();
		results = DaoFactory.getAssignmentDao().getCourseAssignment(classCourseId);
		
		//Scorri le tuple
		for(int i=0 ; i<results.size() ; i++) {
			
			String extractedDescription = results.get(i).getDescription();
			String extractedType = results.get(i).getType();
			Date extractedDate = results.get(i).getCreationDate();
			
			SimpleLogger.info("__________________________________________");
			SimpleLogger.info(i + "DESCRIPTION: (" + extractedDescription +") --- TYPE: (" + extractedType +")");
			SimpleLogger.info("__________________________________________");
			if ( (extractedDescription.equals(expectedDescription)) & (extractedType.equals(expectedType) ) & (extractedDate.equals(expectedDate))){
				numOfMatchings++;
			}
		}
		
		//Controlla quante corrispondenze sono state rinvenute
		assertEquals(expectedMatchings, numOfMatchings);
		
		*/
	}
}
