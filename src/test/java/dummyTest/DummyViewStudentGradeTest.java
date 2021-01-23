package dummyTest;

import java.util.ArrayList;

import logic.model.Grade;
import logic.model.bean.StudentBean;
import logic.model.dao.DaoFactory;
import logic.view.boundary.ViewStudentCareerStudent;

//@author Adriano
public class DummyViewStudentGradeTest {
	
	public static void main(String[] args) {
		//Crea un bean fittizio
		StudentBean studentBean = new StudentBean(2);
		
		//Risultati ottenuti
		ArrayList<String> convertedResults;
		ArrayList<Grade> results = new ArrayList<Grade>();
		
		//Esegui la Boundary corrispondente e recupera i risultati (convertiti)
		ViewStudentCareerStudent boundary = new ViewStudentCareerStudent();
		convertedResults = boundary.viewCareer(studentBean);
		
		//Stampa di controllo
		System.err.println(">>>>>>>>> GRADES GIVEN TO THE STUDENT WITH ID = " + studentBean.getId());
		for(int i=0 ; i<convertedResults.size() ; i++) {
			
			System.err.print(" | MARK: " + convertedResults.get(i));
			i++;
			System.err.print(" | TYPE: " + convertedResults.get(i));
			i++;
			System.err.println(" | DESCRIPTION: " + convertedResults.get(i));
		}
		
		//---------------------------------------------------------------------------------------------
		
		//Chiama direttamente la Dao
		results = DaoFactory.getGradeDao().getStudentGrades(studentBean.getId());
		
		//Stampa di controllo
		System.err.println(">>>>>>>>> GRADES GIVEN TO THE STUDENT WITH ID = " + studentBean.getId());
		for(int i=0 ; i<results.size() ; i++) {
			
			System.err.print("(" + i + ") ");
			System.err.print(" | MARK: " + results.get(i).getMark());
			System.err.print(" | TYPE: " + results.get(i).getType());
			System.err.println(" | DESCRIPTION: " + results.get(i).getDescription());
		}
		
	}
}
