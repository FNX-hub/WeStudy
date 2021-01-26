package logic.view.boundary;


import java.util.List;
import logic.control.ManageClassAssignment;
import logic.model.bean.AssignmentBean;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedAssignment;

//@author Adriano
public class ManageClassAssignmentProfessor {
	
	
	
	public List<ExtendedAssignment> viewClassAssignment(ClassCourseBean bean){
		ManageClassAssignment controller = new ManageClassAssignment();
		return controller.viewClassAssignment(bean);
	}
	
	
	public void createAssignment(AssignmentBean assignmentBean, ClassCourseBean courseBean){
		ManageClassAssignment controller = new ManageClassAssignment();
		controller.createAssignment(assignmentBean, courseBean);
	}
	
}
