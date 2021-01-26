package logic.view.boundary;

import java.util.List;

import logic.control.ViewStudentCareer;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.UserBean;

//@author Adriano
public class ViewStudentCareerStudent{

	public List<ExtendedGrade> view(UserBean studentBean) {
		ViewStudentCareer controller = new ViewStudentCareer();
		return controller.getExtendedStudentCareer(studentBean);
	}
	
}
