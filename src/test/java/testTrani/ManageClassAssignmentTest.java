package testTrani;

import java.util.List;

import org.junit.Test;

import logic.control.SimpleLogger;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedAssignment;
import logic.view.boundary.ManageClassAssignmentProfessor;

public class ManageClassAssignmentTest {
	
	@Test
	public void classAssignmentTest() {
		ManageClassAssignmentProfessor boundary = new ManageClassAssignmentProfessor();
		ClassCourseBean courseBean = new ClassCourseBean(3);
		
		List<ExtendedAssignment> assignments = boundary.viewClassAssignment(courseBean);
		for(int i=0 ; i<assignments.size() ; i++) {
			SimpleLogger.info(assignments.get(i).getCourseName());
			SimpleLogger.info(assignments.get(i).getDescription());
			SimpleLogger.info(assignments.get(i).getType());
			SimpleLogger.info(assignments.get(i).getCreationDate().toString());
			SimpleLogger.info(assignments.get(i).getDeadlineDate().toString());
		}
	}
	
}
