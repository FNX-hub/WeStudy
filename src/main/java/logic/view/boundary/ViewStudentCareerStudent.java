package logic.view.boundary;

import java.util.List;

import logic.control.ViewStudentCareer;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.UserBean;

//@author Adriano
public interface ViewStudentCareerStudent extends RecoverCourseInformation{

	//Dato uno Student -> visualizza TUTTI i suoi Grade
	public default List<ExtendedGrade> view(UserBean studentBean) {
		ViewStudentCareer controller = new ViewStudentCareer();
		return controller.getExtendedStudentCareer(studentBean);
	}
}
