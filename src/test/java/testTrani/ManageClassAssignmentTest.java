package testTrani;

import java.util.List;

import org.junit.Test;

import logic.control.ManageClassAssignment;
import logic.control.SimpleLogger;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedAssignment;

//@author Adriano
public class ManageClassAssignmentTest {
	
	@Test
	public void classAssignmentTest() {
		//crea un bean fittizio
		ClassCourseBean courseBean = new ClassCourseBean(3);
		
		ManageClassAssignment controller = new ManageClassAssignment();
		List<ExtendedAssignment> assignments = controller.viewClassAssignment(courseBean);

		for(int i=0 ; i<assignments.size() ; i++) {
			SimpleLogger.info(assignments.get(i).getCourseName());
			SimpleLogger.info(assignments.get(i).getDescription());
			SimpleLogger.info(assignments.get(i).getType());
			SimpleLogger.info(assignments.get(i).getCreationDate().toString());
			SimpleLogger.info(assignments.get(i).getDeadlineDate().toString());
		}
	}
	
}
