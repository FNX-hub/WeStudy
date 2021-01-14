package logic.model;

public class Meeting {
	
	private String parentId;
	private String professorId;
	private String message;
	private String date;
	
	public Meeting(String parentId, String professorId, String date, String message) {
		this.parentId = parentId;
		this.professorId = professorId;
		this.message = message;
		this.date = date;
	}
	
	public String getParentId() {
		return parentId;
	}

	public String getProfessorId() {
		return professorId;
	}

	public String getMessage() {
		return message;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return  String.format("Date: %s%n, Professor: %s%n Parent %s%nMessage: %s%n",
				date,
				professorId,
				parentId,
				message);	
	}
}
