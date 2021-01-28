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
import logic.model.dao.DaoFactory;

//@author Adriano
public class ManageStudentCareer{
	
	//Dato un Grade e uno Student -> aggiungi quel Grade a quello Student
		public void addGrade(GradeBean gradeBean) {
			
			Integer courseId = gradeBean.getClassCourse();
			Integer studentId = gradeBean.getStudentId();
			
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
		
		
		//Risultato sotto forma di Lista di Bean
		List<ExtendedGrade> convertedCourseGrades = new ArrayList<>();
	
		//Parametri necessari da passare al DAO
		Integer courseId = classCourseBean.getCourseId();
		SimpleLogger.info("DEBUG: courseID:" + courseId);
		
		//Chiedi alla DAO di restituire la lista di studenti di quel corso
		List<Student> students = DaoFactory.getStudentDao().getFromCourseId(courseId);
		
		SimpleLogger.info("DEBUG: il corso contiene nStudenti:" + students.size());
		
		//Per ogni Student nella lista -> richiedi i suoi Grade
		for(int j=0 ; j<students.size() ; j++) {
			Integer studentId = students.get(j).getId();
			String studentName = students.get(j).getName();
			String studentSurname = students.get(j).getSurname();
			SimpleLogger.info("DEBUG: (" + j + ")" + studentId + "/" + studentName + "/" + studentSurname);
			
			//Inizializza un DAO per effettuare la query e prendere i Grade
			//Risultato sottoforma di Lista di Entity
			List<Grade> courseGrades = DaoFactory.getGradeDao().getStudentCourseGrades(courseId,studentId);
			
			for(int k=0 ; k<courseGrades.size() ; k++) {
				
				Date date = courseGrades.get(k).getDate();
				String description = courseGrades.get(k).getDescription();
				Integer mark = courseGrades.get(k).getMark();
				String type = courseGrades.get(k).getType();
				SimpleLogger.info("DEBUG: GRADE NUMERO (" + k + ")" + date + "/" + description + "/" + mark + "/" + type);
				
				ExtendedGrade grade = new ExtendedGrade(studentId,studentName, studentSurname, date,mark, description, type);
				
				convertedCourseGrades.add(grade);
			}
		}
		return convertedCourseGrades;
	}

}
