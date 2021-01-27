package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.model.ClassCourse;
import logic.model.Student;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.StudentBean;
import logic.model.bean.UserBean;
import logic.model.dao.DaoFactory;

//@author Adriano
//Semplice elemento del dominio della soluzione con la responsabilita' di restituire alla GUI 
//alcuni bean propedeutici all'esecuzione di diversi casi d'uso
//Tutti i controller di casi d'uso che hanno bisogno di questi metodi mandano un messaggio a questa classe

//IDEA ALTERNATIVA SCARTATA: una interface con questi metodi
//	tutte le boundary che necessitano questi metodi implementano l'interfaccia
public class RecoverClassCourseInformation {
	
	//Dato id dello Student -> restituisci TUTTI i classCourse che frequenta
	public List<ClassCourseBean> getStudentCourses(UserBean studentBean){
		Integer studentId = studentBean.getId();
		List<ClassCourseBean> convertedCourses = new ArrayList<>();
		
		//Esegui la query
		List<ClassCourse> courses = DaoFactory.getClassCourseDao().getFromStudentId(studentId);
				
		//Converti i risultati ottenuti
		for(int i=0 ; i<courses.size() ; i++) {
			String courseName = courses.get(i).getSubject();
			Integer courseId = courses.get(i).getId();
						
			ClassCourseBean convertedCourse = new ClassCourseBean(courseId,courseName);
			convertedCourses.add(convertedCourse);
		}		
		return convertedCourses;
	}
	
	
	//Dato id del Professor -> restituisci TUTTI i classCourse in cui insegna
	public List<ClassCourseBean> getAllCourses(UserBean professorBean){
		
		Integer profId = professorBean.getId();
		List<ClassCourseBean> convertedCourses = new ArrayList<>();
			
		//Esegui la query
		List<ClassCourse> courses = DaoFactory.getClassCourseDao().getFromProfessorId(profId);
		
		//Converti i risultati ottenuti
		for(int i=0 ; i<courses.size() ; i++) {
			String courseName = courses.get(i).getSubject();
			Integer courseId = courses.get(i).getId();
				
			ClassCourseBean convertedCourse = new ClassCourseBean(courseId,courseName);
			convertedCourses.add(convertedCourse);
		}
			
		return convertedCourses;
	}
		
	//Dato id di un ClassCourse -> restituisci TUTTI gli studenti
	public List<StudentBean> viewClassCourseStudents(ClassCourseBean classCourseBean){
		//Risultato sotto forma di Lista di Bean
		List<StudentBean> convertedCourseGrades = new ArrayList<>();
		
		//Parametri necessari da passare al DAO
		Integer courseId = classCourseBean.getCourseId();
		SimpleLogger.info("DEBUG: courseID:" + courseId);
		
		//Chiedi alla DAO di restituire la lista di studenti di quel corso
		List<Student> students = DaoFactory.getStudentDao().getFromCourseId(courseId);
		SimpleLogger.info("DEBUG: il corso contiene nStudenti:" + students.size());
		
		for(int j=0 ; j<students.size() ; j++) {
			Integer studentId = students.get(j).getId();
			String studentName = students.get(j).getName();
			String studentSurname = students.get(j).getSurname();
			SimpleLogger.info("DEBUG: (" + j + ")" + studentId + "/" + studentName + "/" + studentSurname);
			
			StudentBean studentBean = new StudentBean(studentName,studentSurname,studentId);
			convertedCourseGrades.add(studentBean);
		}
			
		//Restituisci la lista di Bean
		return convertedCourseGrades;
	}
}
