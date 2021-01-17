package logic.model;

import java.util.List;

public class Professor extends User {
	private List<ClassCourse> classCourses;
	
	/*
	 * TODO
	 * Professor newProf = ProfessorDao() //gli restituisce il prof istanziato
	 * 
	 * newProf.setClasses() LO FA CourseClassesDao gli istanzia questo attributo in particolare
	 * 
	 */
	

	
	public Professor(Integer id, String surname, String name, String password) {
		super(id, surname, name, password);
		
		//TODO
		
		//this.classCourses = DaoFactory. 
	}	
}
