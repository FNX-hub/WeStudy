package logic.model;

import logic.model.bean.AssignmentBean;

//@author Adriano
public class AssignmentFactory {

	public Assignment createAssignment(Integer type, AssignmentBean assignmentBean){
		Assignment assignment;
		switch(type) {
			case 1:
				assignment = new ProgrammedTest(assignmentBean.getType() , assignmentBean.getDescription());
				break;
			case 2:
				assignment = new Homework(assignmentBean.getType() , assignmentBean.getDescription());
				break;
			default:
				assignment = null;
		}
		return assignment;
	}
	
}
