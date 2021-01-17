package logic.view.boundary;

import logic.control.ViewStudentCareer;

public class ViewStudentCareerStudent implements ViewStudentCareerInterface{

	@Override
	public void viewCareer(String studentUsername) {
		//Istanzia il controller applicativo corrispondente
		ViewStudentCareer viewStudentCareerController = new ViewStudentCareer();
		
		//TODO
		//viewStudentCareerController
		
		//Inizializza un DAO
		//ViewStudentCareerDummyDAO vscDAO = new ViewStudentCareerDummyDAO();
		
		//Chiama il DAO per eseguire la query & memorizza il risultato
		//All'interno di un blocco try catch per catturare eventuali eccezioni lanciate dal DAO e dovute ad errori di interazione con il DB
		// result = vscDAO.requestCareer(studentUsername);
		
		
		
	}
	
}
