package logic.model.bean;
import java.sql.Date;

public class AssignmentBean {
	private Integer id;
	private String type;
	private String description;
	private Date deadline;
	
	//Utilizzato per crearne uno nuovo
	public AssignmentBean(String type, String description) {
		this.type = type;
		this.description = description;
		
	}
	
	//Utilizzato dalla DAO
	public AssignmentBean(Integer id, String type, String description) {
		this.id = id;
		this.type = type;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String getDescription() {
		return description;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
}
