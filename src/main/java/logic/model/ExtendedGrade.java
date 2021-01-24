package logic.model;

//author Adriano
//Una classe in grado di contenere maggiori informazioni rispetto ad un comune Grade
//Utilizzata per accoppiare informazioni ottenute dalla DAO a seguito di una query su più tabelle
public class ExtendedGrade extends Grade{
	private String coursename;
	
	
	
	public ExtendedGrade(Integer mark, String description, String type) {
		super(mark, description, type);
	}
	
	public ExtendedGrade(Integer mark, String description, String type, String coursename) {
		super(mark, description, type);
		this.coursename = coursename;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
}
