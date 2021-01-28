package logic.model.bean;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//author Adriano


public class ExtendedAssignment{

	private ObjectProperty<LocalDate> creationDate;
	private ObjectProperty<LocalDate> deadlineDate;
	private StringProperty description;
	private StringProperty type;
	private StringProperty courseName;
	
	//Per recuperarlo dalla persistenza
		public ExtendedAssignment(String type, String description, LocalDate creation, LocalDate deadline) {
			this.type = new SimpleStringProperty(type);
			this.description = new SimpleStringProperty(description);
			this.creationDate = new SimpleObjectProperty<>(LocalDate.parse(creation.toString()));
			this.deadlineDate = new SimpleObjectProperty<>(LocalDate.parse(deadline.toString()));
		}
		
		//Per crearlo
		public ExtendedAssignment(String type, String description) {
			this.type = new SimpleStringProperty(type);
			this.description = new SimpleStringProperty(description);
			this.creationDate = new SimpleObjectProperty<>(LocalDate.now());
		}
		
		public ExtendedAssignment(String type, String description, LocalDate creation, LocalDate deadline, String courseName){
			this(type,description,creation,deadline);
			this.courseName = new SimpleStringProperty(courseName);
		}
		
		public LocalDate getCreationDate() {
			return creationDate.get();
		}

		public LocalDate getDeadlineDate() {
			return deadlineDate.get();
		}

		public String getDescription() {
			return description.get();
		}

		public void setCreationDate(LocalDate creationDate) {
			this.creationDate = new SimpleObjectProperty<>(LocalDate.parse(creationDate.toString()));
		}

		public void setDeadlineDate(LocalDate deadlineDate) {
			this.deadlineDate = new SimpleObjectProperty<>(LocalDate.parse(deadlineDate.toString()));
		}

		public void setDescription(String description) {
			this.description = new SimpleStringProperty(description);
		}

		public String getType() {
			return type.get();
		}

		public void setType(String type) {
			this.type = new SimpleStringProperty(type);
		}
	


	public String getCourseName() {
		return courseName.get();
	}

	public void setCourseName(String courseName) {
		this.courseName = new SimpleStringProperty(courseName);
	}

	public ObjectProperty<LocalDate> deadlineProperty() {
		return deadlineDate;
	}

	public StringProperty typeProperty() {
		return type;
	}
	
}
