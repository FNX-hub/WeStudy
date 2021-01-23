package logic.model.bean;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import logic.model.Meeting;
import logic.model.Subject;

public class MeetingBean extends Subject {

	private IntegerProperty parentId;
	private StringProperty parentSurname;
	private IntegerProperty professorId;
	private StringProperty professorSurname;
	private ObjectProperty<LocalDate> date;
	private StringProperty message;
	private Boolean confirmed;
	
	public MeetingBean(Integer parentId, Integer professorId, LocalDate date, String message) {
		this.parentId = new SimpleIntegerProperty(parentId);
		this.professorId = new SimpleIntegerProperty(professorId);
		this.date = new SimpleObjectProperty<>(date);
		this.message = new SimpleStringProperty(message);				
	}
	
	public MeetingBean(Meeting meeting, String parentSurname, String professorSurname) {
		this.parentId = new SimpleIntegerProperty(meeting.getParentId());
		this.parentSurname = new SimpleStringProperty(parentSurname);
		this.professorId = new SimpleIntegerProperty(meeting.getProfessorId());
		this.professorSurname = new SimpleStringProperty(professorSurname);
		this.date = new SimpleObjectProperty<>(meeting.getDate());
		this.message = new SimpleStringProperty(meeting.getMessage());				
	}
	
	public Integer getParentId() {
		return parentId.get();
	}

	public String getParentSurname() {
		return parentSurname.get();
	}

	public Integer getProfessorId() {
		return professorId.get();
	}

	public String getProfessorSurname() {
		return professorSurname.get();
	}

	public LocalDate getDate() {
		return date.get();
	}

	public String getMessage() {
		return message.get();
	}
	
	public Boolean getConfirmed() {
		return confirmed;
	}
	
	public IntegerProperty parentIdProperty() {
		return parentId;
	}

	public StringProperty parentSurnameProperty() {
		return parentSurname;
	}

	public IntegerProperty professorIdProperty() {
		return professorId;
	}

	public StringProperty professorSurnameProperty() {
		return professorSurname;
	}

	public ObjectProperty<LocalDate> dateProperty() {
		return date;
	}

	public StringProperty messageProperty() {
		return message;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
		try {
			notifyObservers();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}	
}
