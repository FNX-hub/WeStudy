package logic.model;

public class Student extends User {

	private String parentId;
	
	public Student(String id, String surname, String name, String password, String parentId) {
		super(id, surname, name, password);
		this.parentId = parentId;
	}

	public String getParentId() {
		return parentId;
	}

	@Override
	public String toString() {
		return String.format("%s%nParentId: %s", super.toString(), parentId) ;
	}
}
