package logic.view.boundary;

import java.util.List;

import logic.control.SimpleLogger;
import logic.control.ViewAssignment;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedAssignment;
import logic.model.bean.UserBean;

public class ViewClassAssignmentStudent {
	
	public ViewClassAssignmentStudent() {
		SimpleLogger.info("ViewClassAssignmentStudent creata con successo");
	}
	
	
	//Restituisci tutti gli assignment di un certo studente in un certo ClassCourse
		public List<ExtendedAssignment> viewAssignment(UserBean studentBean, ClassCourseBean courseBean){
			ViewAssignment controller = new ViewAssignment();
			return controller.viewAssignmentStudentCourse(studentBean, courseBean);
		}
	
	
	//Restituisci TUTTI gli assignment di uno student
	public List<ExtendedAssignment> viewAssignment(UserBean studentBean){
		ViewAssignment controller = new ViewAssignment();
		return controller.viewAssignmentStudent(studentBean);
	}
	
}
