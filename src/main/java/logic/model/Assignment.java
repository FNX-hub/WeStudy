package logic.model;

import java.util.Date;

public class Assignment {
	//MEMO: Date tiene conto di giorno/mese/anno e ore/minuti
	private Date creationDate;
	private Date deadlineDate;
	private String description;
	
	public Assignment(Integer deadlineDay, Integer deadlineMonth, Integer deadlineYear, Integer deadlineHour, Integer deadlineMinute, String description) {
		//this.deadlineDate = new Date(); TODO
		this.creationDate = new Date(); //Data attuale
		this.description = description;
		
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
}
