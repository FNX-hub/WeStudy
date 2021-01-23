package logic.view.boundary;

import java.util.ArrayList;

import logic.control.ViewStudentCareer;
import logic.model.Grade;
import logic.model.bean.StudentBean;

//TODO valutare se è sensato manetenere le due boundary separate
public class ViewStudentCareerStudent implements ViewStudentCareerInterface{

	@Override
	public ArrayList<String> viewCareer(StudentBean studentBean) {
		//Risultato returnato dal Controller appllicativo
		ArrayList<Grade> results = new ArrayList<Grade>();
		
		//Risultato in un formato adeguato alla view
		ArrayList<String> convertedResults = new ArrayList<String>();
		
		//Istanzia il controllore del caso d'uso
		ViewStudentCareer controller = new ViewStudentCareer();
		
		//Esegui il caso d'uso e recupera i risultati
		results = controller.getStudentCareer(studentBean);
				
		//Converti i dati ricevuti in un formalismo adeguato alla GUI
		for(int i=0 ; i<results.size() ; i++) {
			convertedResults.add(results.get(i).getMark().toString());
			convertedResults.add(results.get(i).getType());
			convertedResults.add(results.get(i).getDescription());
		}
		
		//Restituisci i risultati alla GUI
		return convertedResults;
	}
	
}
