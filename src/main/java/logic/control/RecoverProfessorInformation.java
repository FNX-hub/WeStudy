package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.model.Professor;
import logic.model.bean.UserBean;
import logic.model.bean.UserType;
import logic.model.dao.DaoFactory;

//@author Adriano
//Semplice elemento del dominio della soluzione con la responsabilita' di restituire alla GUI 
//alcuni bean contenenti informazioni utili per eseguire casi d'uso, ma non correlati a questi ultimi
public class RecoverProfessorInformation {
	
	//Restituisci alla GUI la lista di TUTTI i Professor
	public List<UserBean> getAllProfessor(){
		//Inizializza il bean da returnare
		List<UserBean> convertedProfessors = new ArrayList<>();
		
		//Istanzia la DAO ed esegui la query
		List<Professor> professors = DaoFactory.getProfessorDao().getAll();
		
		//Converti i dati ricevuti
		UserType type = UserType.PROFESSOR;
		for(int i=0 ; i<professors.size() ; i++) {
			Integer id = professors.get(i).getId();
			String surname = professors.get(i).getSurname();
			String name = professors.get(i).getName();
			UserBean professor = new UserBean(type,id,surname,name);
			convertedProfessors.add(professor);
		}
		return convertedProfessors;
	}
}
