package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.model.Parent;
import logic.model.Professor;
import logic.model.Student;
import logic.model.bean.StudentBean;
import logic.model.bean.UserBean;
import logic.model.bean.UserType;
import logic.model.dao.DaoFactory;

//@author Adriano
//Semplice elemento del dominio della soluzione con la responsabilita' di restituire alla GUI 
//alcuni bean contenenti informazioni utili per eseguire casi d'uso, ma non direttamente correlati a questi ultimi
public class RecoverUserInformation {

	//Restituisci alla GUI la lista di TUTTI i Parent
		public List<UserBean> getAllParent(){
			//Inizializza il bean da returnare
			List<UserBean> convertedParents = new ArrayList<>();
			
			//Istanzia la DAO ed esegui la query
			List<Parent> parents = DaoFactory.getParentDao().getAll();
			
			//Converti i dati ricevuti
			UserType type = UserType.PROFESSOR;
			for(int i=0 ; i<parents.size() ; i++) {
				Integer id = parents.get(i).getId();
				String surname = parents.get(i).getSurname();
				String name = parents.get(i).getName();
				UserBean professor = new UserBean(type,id,surname,name);
				convertedParents.add(professor);
			}
			return convertedParents;
		}
	
	
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
	
	//Dato un Parent -> Restituisci TUTTI i suoi figli Student
		public List<StudentBean> getAllChildren(UserBean parentBean) {
			
			//Lista di bean
			List<StudentBean> convertedStudents = new ArrayList<>();
			
			//Recupera id del Parent
			Integer parentId = parentBean.getId();
			
			//Esegui la query sul DB
			try {
				List<Student> students = DaoFactory.getStudentDao().getFromParentId(parentId);
				
				for(int i=0 ; i<students.size() ; i++) {
					Integer childId = students.get(i).getId();
					String childName = students.get(i).getName();
					String childSurname = students.get(i).getSurname();
					
					StudentBean convertedStudent = new StudentBean(childName, childSurname, childId);
					convertedStudents.add(convertedStudent);
				}
			}
			catch(NullPointerException e) {
				SimpleLogger.info("Questo Parent NON ha Student memorizzati");
			}
			return convertedStudents;
		}
}
