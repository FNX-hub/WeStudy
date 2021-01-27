package logic.control;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import logic.model.ClassCourse;
import logic.model.Grade;
import logic.model.Student;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.UserBean;
import logic.model.dao.DaoFactory;


/*@author Adriano*/
public class ViewStudentCareer{
	
	
	//Dato uno Student -> visualizza TUTTI i grade che ha preso
	public List<ExtendedGrade> getExtendedStudentCareer(UserBean studentBean) {
		
		//Parametri ricevuti
		Integer studentId = studentBean.getId();
	
		//Recupera dalla persistenza nome e cognome dello studente
		Student extractedStudent = DaoFactory.getStudentDao().getFromId(studentId);
		String studentName = extractedStudent.getName();
		String studentSurname =  extractedStudent.getSurname();
		
		//Lista di bean da resituire
		List<ExtendedGrade> convertedGrades = new ArrayList<>();
		
		//Richiedi la lista di ClassCourse che lo studente frequenta
		List<ClassCourse> courses = DaoFactory.getClassCourseDao().getFromStudentId(studentId);
		//Per ogni ClassCourse nella lista -> richiedi tutti i grade presi da quello studente
		for(int i=0 ; i<courses.size() ; i++) {
			Integer courseId = courses.get(i).getId();
			String courseName = courses.get(i).getSubject();
			
			//Richiedi TUTTI i grade in quel ClassCourse presi da quello student
			List<Grade> grades = DaoFactory.getGradeDao().getStudentCourseGrades(courseId, studentId);
			//Per ogni Grade ottenuto -> Convertilo nel formato del bean e aggiungilo alla lista
			for(int k=0 ; k<grades.size() ; k++) {
				String description = grades.get(k).getDescription();
				Integer mark = grades.get(k).getMark();
				String type = grades.get(k).getType();
				Date date = grades.get(k).getDate();
				
				ExtendedGrade grade = new ExtendedGrade(studentId, courseName, studentName, studentSurname, date, mark, description, type);
				convertedGrades.add(grade);
			}
		}
		
		return convertedGrades;
	}
	
}
