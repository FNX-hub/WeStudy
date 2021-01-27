package testTrani;

import java.util.List;

import org.junit.Test;

import logic.control.SimpleLogger;
import logic.model.bean.ExtendedAssignment;
import logic.model.bean.UserBean;
import logic.view.boundary.ViewClassAssignmentStudent;

public class ViewClassAssignmentTest {
	
	@Test
	public void viewAssignmentTest() {
		ViewClassAssignmentStudent boundary2 = new ViewClassAssignmentStudent();
		UserBean studentBean = new UserBean(2);
		
			List<ExtendedAssignment> assignments = boundary2.viewAssignment(studentBean);
			
			for(int i=0 ; i<assignments.size() ; i++) {
				SimpleLogger.info("__________________________________________________");
				SimpleLogger.info(assignments.get(i).getCourseName());
				SimpleLogger.info(assignments.get(i).getDescription());
				SimpleLogger.info(assignments.get(i).getType());
				SimpleLogger.info(assignments.get(i).getCreationDate().toString());
				SimpleLogger.info(assignments.get(i).getDeadlineDate().toString());
			}
	}
	
	
}
