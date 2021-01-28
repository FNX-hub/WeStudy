package logic.model;

import java.util.List;

import logic.model.dao.DaoFactory;


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
		if(gradeList == null) {
			this.gradeList = DaoFactory.getGradeDao().getStudentGrades(super.getId());			
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
