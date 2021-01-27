package testTrani;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import logic.model.Student;
import logic.model.dao.DaoFactory;
import logic.model.dao.StudentDao;

//@author Adriano
public class DatabaseSimpleTest {
	
	@Test
	public void AssignmentDao() {
		//Parametri di controllo
		Integer expectedNumOfFailures = 0;
		Integer actualFailures = 0;
		
		//Parametri attesi
		Integer expectedId = 1;
		String expectedName = "Adrian";
		
		//Richiedi la creazione di una dao
		StudentDao dao = DaoFactory.getStudentDao();
		
		//Richiedi di recuperare i dati dalla persistenza
		Student student = dao.getFromId(1);
		
		//Recupera i parametri ricevuti
		Integer actualId = student.getId();
		String actualName = student.getName();
		
		
		//Controlla
		if(!actualName.equals(expectedName)) {
			actualFailures++;
		}
		if(!actualId.equals(expectedId)) {
			actualFailures++;
		}
		
		assertEquals(expectedNumOfFailures,actualFailures);
	}
}
