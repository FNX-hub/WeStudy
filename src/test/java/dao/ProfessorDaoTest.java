package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.model.Professor;
import logic.model.dao.DaoFactory;
import logic.model.dao.ProfessorDao;

/**
 * @author Simone
 */
public class ProfessorDaoTest {

	private final ProfessorDao dao = DaoFactory.getProfessorDao();
	
	@Test
	public void testGetAll() {
		List<Professor> professorList = new ArrayList<>(); 
		assertEquals(professorList.getClass(), dao.getAll().getClass());
	}

	@Test
	public void testGetFromId() {
		Professor p1 = new Professor(100, "geId", "getId", "getId");
		dao.save(p1);
		Professor p2 = dao.getFromId(100);
		assertEquals(Professor.class, p2.getClass());
		assertEquals(p1.getId(), p2.getId());
		assertEquals(p1.getName(), p2.getName());
		assertEquals(p1.getSurname(), p2.getSurname());
		assertEquals(p1.getPassword(), p2.getPassword());
		dao.delete(p1);
	}

	@Test
	public void testSave() {
		Professor p1 = new Professor(100, "testSave", "testSave", "testSave"); 
		dao.save(p1);
		Professor p2 = dao.getFromId(100);
		assertEquals(Professor.class, p1.getClass());
		assertEquals(Professor.class, p2.getClass());
		assertEquals(p1.getId(), p2.getId());
		assertEquals(p1.getName(), p2.getName());
		assertEquals(p1.getSurname(), p2.getSurname());
		assertEquals(p1.getPassword(), p2.getPassword());
		dao.delete(p1);
	}

	@Test
	public void testUpdate() {
		dao.save(new Professor(100, "testSave", "testSave", "testSave"));
		
		Professor p1 = new Professor(100, "testUpdate", "testUpdate", "testUpdate"); 
		dao.update(p1, new String[] {"100"});
		assertEquals(p1.getId(), dao.getFromId(100).getId());
		assertEquals("testUpdate", dao.getFromId(100).getName());
		assertEquals("testUpdate", dao.getFromId(100).getSurname());
		assertEquals("testUpdate", dao.getFromId(100).getPassword());
		dao.delete(p1);
	}

	@Test
	public void testDelete() {
		dao.save(new Professor(100, "testSave", "testSave", "testSave"));
		Professor p1 = dao.getFromId(100);
		assertNotNull(p1);
		dao.delete(p1);
		assertNull(dao.getFromId(100));
	}
}
