package logic.model;

import java.time.LocalDate;
public class OralAssignment extends Assignment{

	public OralAssignment(String type, String description, LocalDate creation, LocalDate deadline) {
		super(type,description,creation,deadline);
	}
	
	public OralAssignment(String type, String description, LocalDate deadline) {
		super(type,description,deadline);
	}
	
}
