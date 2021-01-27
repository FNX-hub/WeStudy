package logic.view.boundary;

import java.util.List;

import logic.control.RecoverStudentInformation;
import logic.control.ViewStudentCareer;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.StudentBean;
import logic.model.bean.UserBean;

public interface ViewStudentCareerParent extends RecoverCourseInformation {
	
	//Dato un Parent -> restituisci TUTTI i suoi figli Student
	public default List<StudentBean> getAllChildren(UserBean parentBean){
		RecoverStudentInformation controller = new RecoverStudentInformation();
		return controller.getAllChildren(parentBean);
	}
	
	//Dato uno Student (tuo figlio) -> restituisci TUTTI i suoi Grade
	//questa classe NON controlla se lo student fornito e' effettivamente figlio del Parent che la invoca
	//La responsabilita' di fornire uno UserBean corretto appartiene al chiamante 
	public default List<ExtendedGrade> view(UserBean studentBean) {
		ViewStudentCareer controller = new ViewStudentCareer();
		return controller.getExtendedStudentCareer(studentBean);
	}
}
