package logic.view.boundary;

import java.util.ArrayList;
import java.util.List;

import logic.control.ViewStudentCareer;
import logic.model.Grade;
import logic.model.bean.StudentBean;

//TODO valutare se è sensato mantenere le due boundary separate

//@author Adriano
public class ViewStudentCareerStudent{

	public List<String> viewCareer(StudentBean studentBean) {
		//Risultato returnato dal Controller appllicativo
		List<Grade> results = new ArrayList<Grade>();
		
		//Risultato in un formato adeguato alla view
		List<String> convertedResults = new ArrayList<String>();
		
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
