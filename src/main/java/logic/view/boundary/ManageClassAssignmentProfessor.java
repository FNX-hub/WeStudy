package logic.view.boundary;


import java.util.List;
import logic.control.ManageClassAssignment;
import logic.model.bean.AssignmentBean;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedAssignment;

//@author Adriano
public interface ManageClassAssignmentProfessor extends RecoverCourseInformation {
	
	
	//Dato un ClassCourse -> restituisci TUTTI i suoi assignment
	public default List<ExtendedAssignment> viewClassAssignment(ClassCourseBean bean){
		ManageClassAssignment controller = new ManageClassAssignment();
		return controller.viewClassAssignment(bean);
	}
	
	
	//Dato un ClassCourse e un Assignment dalla GUI -> inizializza un nuovo Assignment all'interno di quel ClassCourse
	public default void createAssignment(AssignmentBean assignmentBean, ClassCourseBean courseBean){
		ManageClassAssignment controller = new ManageClassAssignment();
		controller.createAssignment(assignmentBean, courseBean);
	}
	
}
