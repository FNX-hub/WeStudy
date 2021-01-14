package logic.model.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.cj.util.StringUtils;

import logic.model.Meeting;
import logic.model.Subject;
import logic.model.exceptio.FormException;

public class MeetingBean extends Subject {

	private String parentId;
	private String parentSurname;
	private String professorId;
	private String professorSurname;
	private String date;
	private String message;
	private Boolean confirmed;
	

	public MeetingBean(String parentId, String professorId, String date, String message) throws FormException {
		validate(parentId, professorId, date);
		this.parentId = parentId;
		this.professorId = professorId;
		this.date = date;
		this.message = message;
		this.confirmed = false;
	}
	
	public MeetingBean(Meeting meeting, String parentSurname, String professorSurname) {
		this.parentId = meeting.getParentId();
		this.parentSurname = parentSurname;
		this.professorId = meeting.getProfessorId();
		this.professorSurname = professorSurname;
		this.date = meeting.getDate();
		this.message = meeting.getMessage();				
	}
	
	public String getParentId() {
		return parentId;
	}

	public String getParentSurname() {
		return parentSurname;
	}

	public String getProfessorId() {
		return professorId;
	}

	public String getProfessorSurname() {
		return professorSurname;
	}

	public String getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}
	
	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	private void validate(String parentId, String professorId, String date) throws FormException {
		try {
			if(!StringUtils.isStrictlyNumeric(parentId)) {
				throw new IllegalArgumentException("parentId is not an integer");
			}
			if(!StringUtils.isStrictlyNumeric(professorId)) {
				throw new IllegalArgumentException("professorId is not an integer");
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			dateFormat.parse(date.trim());
		}
		catch (IllegalArgumentException id) {
			throw new FormException(id.getMessage(), id.getCause());
		}
		catch (ParseException d) {
			throw new FormException("date is invalid or not in yyyy-MM-dd format", d.getCause());
		}
	}	
}
