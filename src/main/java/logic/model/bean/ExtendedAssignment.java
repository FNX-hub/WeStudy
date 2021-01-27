package logic.model.bean;

import java.time.LocalDate;

//author Adriano


public class ExtendedAssignment{
	private LocalDate creationDate;
	private LocalDate deadlineDate;
	private String description;
	private String type;
	private String courseName;
	
	//Per recuperarlo dalla persistenza
		public ExtendedAssignment(String type, String description, LocalDate creation, LocalDate deadline) {
			this.type = type;
			this.description = description;
			this.creationDate = creation;
			this.deadlineDate = deadline;
		}
		
		//Per crearlo
		public ExtendedAssignment(String type, String description) {
			this.type = type;
			this.description = description;
			this.creationDate = LocalDate.now();
		}
		
		public ExtendedAssignment(String type, String description, LocalDate creation, LocalDate deadline, String courseName){
			this(type,description,creation,deadline);
			this.courseName = courseName;
		}
		

		public LocalDate getCreationDate() {
			return creationDate;
		}

		public LocalDate getDeadlineDate() {
			return deadlineDate;
		}

		public String getDescription() {
			return description;
		}

		public void setCreationDate(LocalDate creationDate) {
			this.creationDate = creationDate;
		}

		public void setDeadlineDate(LocalDate deadlineDate) {
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
