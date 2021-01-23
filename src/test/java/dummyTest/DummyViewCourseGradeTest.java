package dummyTest;

import java.util.ArrayList;

import logic.model.Grade;
import logic.model.bean.ClassCourseBean;
import logic.model.dao.DaoFactory;
import logic.view.boundary.ManageStudentCareerProfessor;

//@author Adriano
public class DummyViewCourseGradeTest {
	
	
	public static void main(String[] args) {
		System.err.println("MESSO COME COMMENTO PERCHE' SONARCLOUD NON PUO' ACCEDERE AL MIO DB IN LOCALE");
		/*
		
		//Crea un bean fittizio
		ClassCourseBean classCourseBean = new ClassCourseBean(1,"Matematica");
		
		//Risultati ottenuti
		ArrayList<String> convertedResults;
		ArrayList<Grade> results = new ArrayList<Grade>();
		
		//Esegui la Boundary corrispondente e recupera i risultati (convertiti)
		ManageStudentCareerProfessor boundary = new ManageStudentCareerProfessor();
		convertedResults = boundary.viewClassCourseGrades(classCourseBean);
		
		
		//Stampa di controllo
		System.err.println(">>>>>>>>> GRADES GIVEN IN THE CLASS COURSE WITH ID = " + classCourseBean.getCourseId());
		for(int i=0 ; i<convertedResults.size() ; i++) {
			
			System.err.print(" | MARK: " + convertedResults.get(i));
			i++;
			System.err.print(" | TYPE: " + convertedResults.get(i));
			i++;
			System.err.println(" | DESCRIPTION: " + convertedResults.get(i));
		}
		
		//---------------------------------------------------------------------------------------------
		
		//Chiama direttamente la Dao
		results = DaoFactory.getGradeDao().getCourseGrades(classCourseBean.getCourseId());
		
		//Stampa di controllo
		System.err.println(">>>>>>>>> GRADES GIVEN IN THE CLASS COURSE WITH ID = " + classCourseBean.getCourseId());
		for(int i=0 ; i<results.size() ; i++) {
			
			System.err.print("(" + i + ") ");
			System.err.print(" | MARK: " + results.get(i).getMark());
			System.err.print(" | TYPE: " + results.get(i).getType());
			System.err.println(" | DESCRIPTION: " + results.get(i).getDescription());
		}
		*/
	}
}
