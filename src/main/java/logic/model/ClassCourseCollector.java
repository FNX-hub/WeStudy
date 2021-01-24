package logic.model;

import java.util.ArrayList;
import java.util.List;

//Questa classe ha la responsabilità di collezionare dei riferimenti a tutti i ClassCourse creati dall'applicazione
public class ClassCourseCollector {
	private List<ClassCourse> classCourses;
	private static ClassCourseCollector instance = null;
	
	
	//synchronized serve per evitare anomalie dovute alla concorrenza dei thread
	//serve per evitare che due thread entrino contemporaneamente dentro questo metodo e finiscano con il creare 2 istanze della classe
	public static synchronized ClassCourseCollector getSingletonInstance() {
		if(instance == null){
			instance = new ClassCourseCollector();
		}
		return instance;
	}
	
	public ClassCourseCollector() {
		this.classCourses = new ArrayList<>();
	}

	public List<ClassCourse> getClassCourses() {
		return classCourses;
	}

	public void setClassCourses(List<ClassCourse> classCourses) {
		this.classCourses = classCourses;
	}
	
	public void addCourse(ClassCourse classCourse) {
		this.classCourses.add(classCourse);
	}
	
	public ClassCourse searchById(Integer searchedId) {
		ClassCourse tempClassCourse;
		for(int i=0 ; i<this.classCourses.size() ; i++) {
			tempClassCourse = this.classCourses.get(i);
			if ( tempClassCourse.getId() == searchedId ){
				return tempClassCourse;
			}
		}
		return null;
	}
}
