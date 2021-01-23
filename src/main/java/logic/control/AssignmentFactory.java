package logic.control;

import logic.model.Assignment;
import logic.model.Homework;
import logic.model.ProgrammedTest;

public class AssignmentFactory {
	

	
	public Assignment createAssignment(Integer type){
		Assignment assignment;
		switch(type) {
			case 1:
				assignment = new ProgrammedTest();
				break;
			case 2:
				assignment = new Homework();
				break;
			default:
				assignment = null;
		}
		return assignment;
	}
	
}
