package logic.model;

import java.sql.Date;

public class OralAssignment extends Assignment{

	public OralAssignment(String type, String description, Date creation, Date deadline) {
		super(type,description,creation,deadline);
	}
	
	public OralAssignment(String type, String description) {
		super(type, description);
	}
	
}
