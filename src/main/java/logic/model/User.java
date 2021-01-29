package logic.model;

public abstract class User {

	protected Integer id;
	protected String surname;
	protected String name;
	protected String password;
	
	protected User(Integer id, String surname, String name, String password) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public String getSurname() {
		return surname;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("%s%nUserId: %d%nName: %s%nSurname: %s%nPassword: %s%n", super.toString(), id, name, surname, password);
	}	
}
