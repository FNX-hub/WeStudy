package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.model.Parent;
import logic.model.Student;
import logic.model.dao.DaoFactory;
import logic.model.dao.StudentDao;

/**
 * @author Simone
 */
public class StudentDaoTest {

	private final StudentDao dao = DaoFactory.getStudentDao();
	
	@Test
	public void testGetAll() {
		List<Student> studentList = new ArrayList<>(); 
		assertEquals(studentList.getClass(), dao.getAll().getClass());
	}

	@Test
	public void testGetFromId() {
		DaoFactory.getParentDao().save(new Parent(100, "tmp", "tmp", "tmp", "tmp"));
		Student s1 = new Student(100, "geId", "getId", "getId", 100);
		dao.save(s1);
		Student s2 = dao.getFromId(100);
		assertEquals(Student.class, s2.getClass());
		assertEquals(s1.getId(), s2.getId());
		assertEquals(s1.getName(), s2.getName());
		assertEquals(s1.getSurname(), s2.getSurname());
		assertEquals(s1.getPassword(), s2.getPassword());
		dao.delete(s1);
		DaoFactory.getParentDao().delete(new Parent(100, "tmp", "tmp", "tmp", "tmp"));
	}

	@Test
	public void testGetFromParentId() {
		DaoFactory.getParentDao().save(new Parent(100, "tmp", "tmp", "tmp", "tmp"));
		Student s1 = new Student(100, "geId", "getId", "getId", 100);
		dao.save(s1);
		List<Student> studentList = new ArrayList<>(); 
		assertEquals(studentList.getClass(), dao.getFromParentId(100).getClass());
		dao.delete(s1);
		DaoFactory.getParentDao().delete(new Parent(100, "tmp", "tmp", "tmp", "tmp"));
	}
	
	@Test
	public void testUpdate() {
		DaoFactory.getParentDao().save(new Parent(100, "tmp", "tmp", "tmp", "tmp"));
		Student s1 = new Student(100, "testSave", "testSave", "testSave", 100);
		dao.save(s1);
		
		Student s2 = new Student(100, "testUpdate", "testUpdate", "testUpdate", 100);
		dao.update(s2, new String[] {"100"});
		
		assertEquals(s1.getId(), dao.getFromId(100).getId());
		assertEquals("testUpdate", dao.getFromId(100).getName());
		assertEquals("testUpdate", dao.getFromId(100).getSurname());
		assertEquals("testUpdate", dao.getFromId(100).getPassword());
		assertEquals(s1.getParentId(), dao.getFromId(100).getParentId());
		dao.delete(s2);
		DaoFactory.getParentDao().delete(new Parent(100, "tmp", "tmp", "tmp", "tmp"));
	}
}
