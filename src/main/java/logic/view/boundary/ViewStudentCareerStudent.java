package logic.view.boundary;

import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.control.ViewStudentCareer;
import logic.model.ExtendedGrade;
import logic.model.Grade;
import logic.model.bean.UserBeanWeb;

//TODO valutare se è sensato mantenere le due boundary separate

//@author Adriano
public class ViewStudentCareerStudent{

	public List<String> viewExtendedCareer(UserBeanWeb studentBean){
		//Risultato returnato dal Controller appllicativo
		List<ExtendedGrade> results;
				
		//Risultato in un formato adeguato alla view
		List<String> convertedResults = new ArrayList<>();
				
		//Istanzia il controllore del caso d'uso
		ViewStudentCareer controller = new ViewStudentCareer();
				
		//Esegui il caso d'uso e recupera i risultati
		results = controller.getExtendedStudentCareer(studentBean);
		
		try {
			//Converti i dati ricevuti in un formalismo adeguato alla GUI
			for(int i=0 ; i<results.size() ; i++) {
				convertedResults.add(results.get(i).getCoursename());
				convertedResults.add(results.get(i).getMark().toString());
				convertedResults.add(results.get(i).getType());
				convertedResults.add(results.get(i).getDescription());
				convertedResults.add(results.get(i).getDatabaseDate().toString());
			}
		}
		//SE la query NON ha restituito nulla
		//	entra in logica di errore
		catch(NullPointerException e)
    	{
			//Crea un'unica tupla contenente una frase esplicativa
			SimpleLogger.info("NullPointerException caught");
			convertedResults.add("You");
			convertedResults.add("don't");
			convertedResults.add("have");
			convertedResults.add("any");
			convertedResults.add("grade");
    	}
				
		//Restituisci i risultati alla GUI
		return convertedResults;
	}
	
	public List<String> viewCareer(UserBeanWeb studentBean) {
		//Risultato returnato dal Controller appllicativo
		List<Grade> results;
		
		//Risultato in un formato adeguato alla view
		List<String> convertedResults = new ArrayList<>();
		
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
