package logic.model.bean;

//@author Adriano
public class StudentBean {
	private String name;
	private String surname;
	private Integer id;
	
	public StudentBean(Integer id) {
		this.id = id;
	}
	
	public StudentBean(String name, String surname, Integer id) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		try {
			return String.format("%s-%s", surname, name);
		} catch (NullPointerException e) {
			return super.toString();			
		}
	}
	
	
}
