package logic.model;

import java.time.LocalDate;

//@author Adriano

//non voglio che venga istanziata
//Solo le sue classi figlie sono istanziabili
public abstract class Assignment {
	protected LocalDate creationDate;
	protected LocalDate deadlineDate;
	protected String description;
	protected String type; //ORAL, PROJECT, WRITTEN
	
	
	//Per recuperarlo dalla persistenza
	public Assignment(String type, String description, LocalDate creation, LocalDate deadline) {
		this.type = type;
		this.description = description;
		this.creationDate = creation;
		this.deadlineDate = deadline;
	}
	
	//Per crearlo da GUI
	public Assignment(String type, String description, LocalDate deadline) {
		this.type = type;
		this.description = description;
		this.creationDate = LocalDate.now();
		this.deadlineDate = deadline;
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
}
