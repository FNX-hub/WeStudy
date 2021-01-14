package logic.model;

import java.util.Date;

public abstract class Test {
	protected Date creationDate;
	protected Date date;
	protected String subject;
	protected String description;
	
	
	public Date getCreationDate() {
		return creationDate;
	}
	public Date getDate() {
		return date;
	}
	public String getSubject() {
		return subject;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
