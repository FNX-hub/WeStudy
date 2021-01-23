package logic.model;

import java.time.LocalDate;

public class Meeting {
	
	private Integer parentId;
	private Integer professorId;
	private String message;
	private LocalDate date;
	
	public Meeting(Integer parentId, Integer professorId, LocalDate date, String message) {
		this.parentId = parentId;
		this.professorId = professorId;
		this.message = message;
		this.date = date;
	}
	
	public Integer getParentId() {
		return parentId;
	}

	public Integer getProfessorId() {
		return professorId;
	}

	public String getMessage() {
		return message;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return  String.format("Date: %s%n, Professor: %d%n Parent %d%nMessage: %s%n",
				date.toString(),
				professorId,
				parentId,
				message);	
	}
}
