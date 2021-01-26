package testTrani;

import java.util.List;

import org.junit.Test;

import logic.control.SimpleLogger;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.UserBean;
import logic.view.boundary.ViewStudentCareerStudent;

public class ViewCareerTest {
	
	@Test
	public void viewCareer() {
		UserBean studentBean = new UserBean(1);
		
		ViewStudentCareerStudent boundary = new ViewStudentCareerStudent();
		List<ExtendedGrade> grades = boundary.view(studentBean);
		
		for(int i=0 ; i<grades.size() ; i++) {
			SimpleLogger.info("| " + grades.get(i).getStudentId() + grades.get(i).getCoursename() + grades.get(i).getStudentName() + grades.get(i).getStudentSurname() + grades.get(i).getType()  + grades.get(i).getMark()  + grades.get(i).getDatabaseDate()  );
			
		}
	}
}
