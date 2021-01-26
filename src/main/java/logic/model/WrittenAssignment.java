package logic.model;

import java.sql.Date;

public class WrittenAssignment extends Assignment{

	public WrittenAssignment(String type, String description, Date deadline) {
		super(type,description,deadline);
	}
	
	public WrittenAssignment(String type, String description, Date creation, Date deadline) {
		super(type,description,creation,deadline);
	}
	
}
