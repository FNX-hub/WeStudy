package logic.model;

import java.time.LocalDate;

public class ProjectAssignment extends Assignment{

	public ProjectAssignment(String type, String description, LocalDate creation, LocalDate deadline) {
		super(type,description,creation,deadline);
	}
	
	public ProjectAssignment(String type, String description, LocalDate deadline) {
		super(type,description,deadline);
	}
	
}

