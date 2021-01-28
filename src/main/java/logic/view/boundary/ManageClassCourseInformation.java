package logic.view.boundary;

import java.util.List;

import logic.control.ManageStudentCareer;
import logic.control.RecoverClassCourseInformation;
import logic.control.RecoverStudentInformation;
import logic.control.ViewStudentCareer;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.ExtendedGrade;
import logic.model.bean.GradeBean;
import logic.model.bean.StudentBean;
import logic.model.bean.UserBean;

public interface ManageClassCourseInformation {

	//Dato un professor -> Restituisci TUTTI i classCourse in cui quel professor insegna
	public default List<ClassCourseBean> getProfessorCourses(UserBean professorBean){
		RecoverClassCourseInformation controller = new RecoverClassCourseInformation();
		return controller.getAllCourses(professorBean);
	}
	
	//Dato uno Student -> restituisci TUTTI i classCourse che frequenta
	public default List<ClassCourseBean> getStudentCourses(UserBean studentBean){
		RecoverClassCourseInformation controller = new RecoverClassCourseInformation();
		return controller.getStudentCourses(studentBean);
	}
	
	public default List<ClassCourseBean> getStudentCourses(StudentBean studentBean){
		RecoverClassCourseInformation controller = new RecoverClassCourseInformation();
		return controller.getStudentCourses(new UserBean(studentBean.getId()));
	}
		
	//Dato un classCourse -> restituisci elenco di student che ne fanno parte
	public default List<StudentBean> getStudentsByCourse(ClassCourseBean classCourseBean){
		RecoverClassCourseInformation controller = new RecoverClassCourseInformation();
		return controller.viewClassCourseStudents(classCourseBean);
	}
	
	//Dato uno Student -> visualizza TUTTI i suoi Grade
	public default List<ExtendedGrade> getStudentGrades(UserBean studentBean) {
		ViewStudentCareer controller = new ViewStudentCareer();
		return controller.getExtendedStudentCareer(studentBean);
	}
	public default List<ExtendedGrade> getStudentGrades(StudentBean studentBean) {
		ViewStudentCareer controller = new ViewStudentCareer();
		return controller.getExtendedStudentCareer(new UserBean(studentBean.getId()));
	}
	
	//Dato un Parent -> restituisci TUTTI i suoi figli Student
	public default List<StudentBean> getAllChildren(UserBean parentBean){
		RecoverStudentInformation controller = new RecoverStudentInformation();
		return controller.getAllChildren(parentBean);
	}
	
	//Dato un Grade, un id del ClassCourse e un id di uno Student ()-> Aggiungi a quello Student quel Grade
	//NB questo metodo NON controlla se tale studente fa parte di quel corso, la responsabilita' e' assegnata al chiamante
	public default void addGrade(GradeBean gradeBean) {
		//Inizializza il controller per l'esecuzione del caso d'uso
		ManageStudentCareer controller = new ManageStudentCareer();
		
		//esegui il caso d'uso
		controller.addGrade(gradeBean);
	}
}
