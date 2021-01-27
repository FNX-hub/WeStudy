package logic.control;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import logic.model.Grade;
import logic.model.Student;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedGrade;
import logic.model.ClassCourse;
import logic.model.bean.GradeBean;
import logic.model.bean.UserBean;
import logic.model.dao.DaoFactory;


public class ManageStudentCareer{
	
	
	//Dato id del professore-> restituisci TUTTI i classCourse in cui insegna
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
	
	//Aggiungi un certo voto ad uno studente in un certo course
	public void addGrade(GradeBean gradeBean, ClassCourseBean classCourseBean, UserBean studentBean) {
		
		Integer courseId = classCourseBean.getCourseId();
		Integer studentId = studentBean.getId();
		
		String description = gradeBean.getDescription();
		String type = gradeBean.getType();
		Integer value = gradeBean.getValue();
		
		//Recupera dalla persistenza il classCourse corrispondente
		ClassCourse temporaryCourse = new ClassCourse(courseId);
		
		Grade grade = new Grade(temporaryCourse,value, description, type);
			
		//Istanzia una DAO e memorizza il Grade nella persistenza
		DaoFactory.getGradeDao().save(grade,studentId,courseId);
	}
	
	//Dato id di un ClassCourse -> restituisci TUTTI i Grade
	public List<ExtendedGrade> viewClassCourseGrades(ClassCourseBean  classCourseBean){
		
		//Risultato sottoforma di Lista di Entity
		List<Grade> courseGrades;
		
		//Risultato sotto forma di Lista di Bean
		List<ExtendedGrade> convertedCourseGrades = new ArrayList<>();
	
		//Parametri necessari da passare al DAO
		Integer courseId = classCourseBean.getCourseId();
		
		
		//Chiedi alla DAO di restituire la lista di studenti di quel corso
		List<Student> students = DaoFactory.getStudentDao().getFromCourseId(courseId);
		
		//Per ogni Student nella lista -> richiedi i suoi Grade
		for(int j=0 ; j<students.size() ; j++) {
			Integer studentId = students.get(j).getId();
			String studentName = students.get(j).getName();
			String studentSurname = students.get(j).getSurname();
			
			//Inizializza un DAO per effettuare la query e prendere i Grade
			courseGrades = DaoFactory.getGradeDao().getStudentGrades(studentId);
			
			for(int k=0 ; k<courseGrades.size() ; k++) {
				Date date = courseGrades.get(k).getDate();
				String description = courseGrades.get(k).getDescription();
				Integer mark = courseGrades.get(k).getMark();
				String type = courseGrades.get(k).getType();
			
				ExtendedGrade grade = new ExtendedGrade(studentId,studentName, studentSurname, date,mark, description, type);
				
				convertedCourseGrades.add(grade);
			}
		}
		return convertedCourseGrades;
	}

}
