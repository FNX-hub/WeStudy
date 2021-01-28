package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.model.Student;
import logic.model.bean.StudentBean;
import logic.model.bean.UserBean;
import logic.model.dao.DaoFactory;

//@author Adriano
//Semplice elemento del dominio della soluzione con la responsabilita' di restituire alla GUI 
//alcuni bean contenenti informazioni utili per eseguire casi d'uso, ma non correlati a questi ultimi
public class RecoverStudentInformation {

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
