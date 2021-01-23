package logic.model;

import java.time.LocalDate;

public class Assignment {
	private LocalDate creationDate;
	private LocalDate deadlineDate;
	private String description;
	
	public Assignment() {
		this.creationDate = LocalDate.now();
	}
	
	public Assignment(String description) {
		this.creationDate = LocalDate.now();
		this.description = description;
	}
	
	public Assignment(Integer deadlineDay, Integer deadlineMonth, Integer deadlineYear, Integer deadlineHour, Integer deadlineMinute, String description) {
		
		//TODO inserire la data corretta nella deadLineDate
		this.deadlineDate = LocalDate.now();
		this.creationDate = LocalDate.now();
		this.description = description;
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
}
