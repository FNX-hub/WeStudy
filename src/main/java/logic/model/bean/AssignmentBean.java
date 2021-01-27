package logic.model.bean;
import java.time.LocalDate;

//@author Adriano
public class AssignmentBean {
	private Integer id;
	private String type;
	private String description;
	private LocalDate deadline;
	
	//Utilizzato dalla GUI
	public AssignmentBean(String type, String description, LocalDate deadline) throws WrongDeclarationCustomException{
		
		//lancia eccezione se viene fornita da input una deadline precedente alla data corrente
		if(deadline.compareTo(LocalDate.now())<0) {
			throw new WrongDeclarationCustomException("Wrong parameters");
		}
		this.type = type;
		this.description = description;
		this.deadline = deadline;
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

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
}
