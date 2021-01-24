package logic.model;


/* @author Adriano */
public class ClassCourseFactory {
	
	
	//Utilizzato dalla DAO
	public ClassCourse createClassCourse(Integer id, String subject) {
		return new ClassCourse(subject, id);
	}
}
