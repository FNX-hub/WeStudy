package logic.view.boundary;

import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.control.ViewAssignment;
import logic.model.ExtendedAssignment;
import logic.model.bean.StudentBean;

public class ViewClassAssignmentStudent {
	
	public ViewClassAssignmentStudent() {
		SimpleLogger.info("ViewClassAssignmentStudent creata con successo");
	}
	
	
	//Dato uno studente, restituisci TUTTI gli assignment di tutti i calssCourse di cui fa parte
	public List<String> viewAssignment(StudentBean studentBean){
		//Liste utilizzate
		List<String> convertedResults = new ArrayList<>();
		List<ExtendedAssignment> results = new ArrayList<>();
		
		//Istanzia il controller applicativo
		ViewAssignment controller = new ViewAssignment();
		
		//Esegui il caso d'uso e recupera i risultati
		results = controller.viewAssignmentStudent(studentBean);
		
		//Converti i risultati
		for(int i=0 ; i<results.size() ; i++) {
			convertedResults.add(results.get(i).getCourseName());
			convertedResults.add(results.get(i).getType());
			convertedResults.add(results.get(i).getDescription());
			convertedResults.add(results.get(i).getCreationDate().toString());
			convertedResults.add(results.get(i).getDeadlineDate().toString());
		}
		
		//Restituisci i risultati convertiti alla grafica
		return convertedResults;
	}
}
