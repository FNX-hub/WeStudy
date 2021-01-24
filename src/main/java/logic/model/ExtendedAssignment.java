package logic.model;

import java.sql.Date;

//author Adriano
//Una classe in grado di contenere maggiori informazioni rispetto ad un comune Assignment
//Utilizzata per accoppiare informazioni ottenute dalla DAO a seguito di una query su più tabelle

public class ExtendedAssignment extends Assignment{
	private String courseName;
	
	public ExtendedAssignment(String type, String description, Date creation, Date deadline, String courseName){
		super(type,description,creation,deadline);
		this.courseName = courseName;
	}
	
	public ExtendedAssignment(String type, String description, Date creation, Date deadline){
		super(type,description,creation,deadline);
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
