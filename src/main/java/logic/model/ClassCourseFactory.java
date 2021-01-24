package logic.model;

import logic.model.bean.ClassCourseBean;

/* @author Adriano */
public class ClassCourseFactory {
	
	
	//Utilizzato dalla DAO
	public ClassCourse createClassCourse(Integer id, String subject) {
		ClassCourse course = new ClassCourse(subject, id);
		return course;
	}
}
