package logic.model;

import java.util.List;

public class Student extends User {
	private List<Grade> gradeList;
	private Integer parentId;
	
	public Student(Integer id, String surname, String name, String password, Integer parentId) {
		super(id, surname, name, password);
		this.parentId = parentId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public List<Grade> getGrades() {
		if(gradeList.isEmpty()) {
			//TODO controllare la correttezza
			// add --> this.grades = DaoFactory.getGradeDao().getGradeByStudentId(getId());			
		}
		return gradeList;
	}
	public void addGrade(Grade grade) {
		this.gradeList.add(grade);
	}
	public void deleteGrade(Grade grade) {
		this.gradeList.remove(grade);
	}
	@Override
	public String toString() {
		return String.format("%sUserType: Student%n", super.toString()) ;
	}

}
