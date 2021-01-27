package logic.model;

import java.time.LocalDate;

public class WrittenAssignment extends Assignment{

	public WrittenAssignment(String type, String description, LocalDate deadline) {
		super(type,description,deadline);
	}
	
	public WrittenAssignment(String type, String description, LocalDate creation, LocalDate deadline) {
		super(type,description,creation,deadline);
	}
	
}
