package logic.view.boundary;

import java.util.List;

import logic.control.RecoverClassCourseInformation;
import logic.model.bean.ClassCourseBean;
import logic.model.bean.StudentBean;
import logic.model.bean.UserBean;

//classe NON legata all'esecuzione di un singolo caso d'uso, 
//ma con la responsabilita' di fornire informazioni propedeutiche a vari casi d'uso
public interface RecoverCourseInformation {

	//Dato un professor -> Restituisci TUTTI i classCourse in cui quel professor insegna
	public default List<ClassCourseBean> getAllCourses(UserBean professorBean){
		RecoverClassCourseInformation controller = new RecoverClassCourseInformation();
		return controller.getAllCourses(professorBean);
	}
	
	//Dato uno Student -> restituisci TUTTI i classCourse che frequenta
	public default List<ClassCourseBean> getStudentCourses(UserBean studentBean){
		RecoverClassCourseInformation controller = new RecoverClassCourseInformation();
		return controller.getStudentCourses(studentBean);
	}
		
	//Dato un classCourse -> restituisci elenco di student che ne fanno parte
	public default List<StudentBean> getStudents(ClassCourseBean classCourseBean){
		RecoverClassCourseInformation controller = new RecoverClassCourseInformation();
		return controller.viewClassCourseStudents(classCourseBean);
	}
	
}
