package logic.model.dao;

public class DaoFactory {

	private DaoFactory() {
	    throw new IllegalStateException("DaoFactory class");
	  }
	
	public static MeetingDao getMeetingDao() {
		return new MeetingDao();
	}
	
	public static ProfessorDao getProfessorDao() {
		return new ProfessorDao();
	}
	
	public static ParentDao getParentDao() {
		return new ParentDao();
	}

	public static StudentDao getStudentDao() {
		return new StudentDao();
	}
	
	public static GradeDao getGradeDao() {
		return new GradeDao();
	}
	
	public static ClassCourseDao getClassCourseDao() {
		return new ClassCourseDao();
	}
}
