package logic.model;

import java.sql.Date;

public class ProjectAssignment extends Assignment{

	public ProjectAssignment(String type, String description, Date creation, Date deadline) {
		super(type,description,creation,deadline);
	}
	
	public ProjectAssignment(String type, String description) {
		super(type, description);
	}

}
