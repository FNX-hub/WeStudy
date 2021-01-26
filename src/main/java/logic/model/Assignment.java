package logic.model;

import java.sql.Date;
import java.time.LocalDate;

//@author Adriano

//non voglio che venga istanziata
//Solo le sue classi figlie sono istanziabili
public abstract class Assignment {
	protected Date creationDate;
	protected Date deadlineDate;
	protected String description;
	protected String type; //ORAL, PROJECT, WRITTEN
	
	
	//Per recuperarlo dalla persistenza
	public Assignment(String type, String description, Date creation, Date deadline) {
		this.type = type;
		this.description = description;
		this.creationDate = creation;
		this.deadlineDate = deadline;
	}
	
	//Per crearlo da GUI
	public Assignment(String type, String description, Date deadline) {
		this.type = type;
		this.description = description;
		this.creationDate = Date.valueOf(LocalDate.now());
		this.deadlineDate = deadline;
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
}
