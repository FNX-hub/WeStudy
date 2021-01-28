package logic.view.boundary;

import java.util.List;

import logic.control.ViewAssignment;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedAssignment;
import logic.model.bean.UserBean;

public interface ViewClassAssignmentStudent extends RecoverCourseInformation{
	
	
	//Dato uno Student e un ClassCourse -> Restituisci tutti gli assignment in quel ClassCourse
	public default List<ExtendedAssignment> viewAssignment(UserBean studentBean, ClassCourseBean courseBean){
		ViewAssignment controller = new ViewAssignment();
		return controller.viewAssignmentStudentCourse(courseBean);
	}
	
	
	//Dato uno Student -> restituisci TUTTI i suoi Assignment
	public default List<ExtendedAssignment> viewAssignment(UserBean studentBean){
		ViewAssignment controller = new ViewAssignment();
		return controller.viewAssignmentStudent(studentBean);
	}
	
}
