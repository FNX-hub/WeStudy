package logic.control;

import java.util.List;

import logic.model.Grade;
import logic.model.bean.StudentBean;
import logic.model.bean.UserBean;
import logic.model.dao.DaoFactory;


/*@author Adriano*/
public class ViewStudentCareer {
	
	public ViewStudentCareer() {
		SimpleLogger.info("ViewStudentCareer costruttore");
	}
	
	public List<Grade> getStudentCareer(StudentBean studentBean){
		//Inizializza una lista per contenere i dati (formato adeguato alle entity)
		List<Grade> yourGrades;
				
		//Inizializza il DAO e raccogli i risultati della query
		yourGrades = DaoFactory.getGradeDao().getStudentGrades(studentBean.getId());
		
		//Restituisci i dati ottenuti
		return yourGrades;
	}
	
	//TODO verificare se utile, altrimenti va eliminata
	//Dato il tuo id/username, restituisci la tua lista di voti
	public List<Grade> getCareer(UserBean bean) {
		
		//Inizializza una lista vuota
		List<Grade> yourGrades;
		
		//Inizializza il DAO e raccogli i risultati della query
		yourGrades = DaoFactory.getGradeDao().getStudentGrades(bean.getId());
		
		return yourGrades;
	}
	
}
