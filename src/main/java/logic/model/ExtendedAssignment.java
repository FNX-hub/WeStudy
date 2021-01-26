package logic.model;

import java.sql.Date;
import java.time.LocalDate;

//author Adriano


public class ExtendedAssignment{
	protected Date creationDate;
	protected Date deadlineDate;
	protected String description;
	protected String type;
	private String courseName;
	
	//Per recuperarlo dalla persistenza
		public ExtendedAssignment(String type, String description, Date creation, Date deadline) {
			this.type = type;
			this.description = description;
			this.creationDate = creation;
			this.deadlineDate = deadline;
		}
		
		//Per crearlo
		public ExtendedAssignment(String type, String description) {
			this.type = type;
			this.description = description;
			this.creationDate = Date.valueOf(LocalDate.now());
		}
		
		public ExtendedAssignment(String type, String description, Date creation, Date deadline, String courseName){
			this(type,description,creation,deadline);
			this.courseName = courseName;
		}
		

		public Date getCreationDate() {
			return creationDate;
		}

		public Date getDeadlineDate() {
			return deadlineDate;
		}

		public String getDescription() {
			return description;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		public void setDeadlineDate(Date deadlineDate) {
			this.deadlineDate = deadlineDate;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
