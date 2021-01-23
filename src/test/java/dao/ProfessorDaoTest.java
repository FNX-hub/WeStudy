package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

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
	
//	@Test
//	public void testGetAll() {
//		List<Professor> professorList = new ArrayList<>(); 
//		assertEquals(professorList.getClass(), dao.getAll().getClass());
//	}

//	@Test
//	public void testGetFromId() {
//		Professor p1 = new Professor(100, "geId", "getId", "getId");
//		if(!dao.save(p1)) fail("can't save");
//		Professor p2 = dao.getFromId(100);
//		assertEquals(Professor.class, p2.getClass());
//		assertEquals(p1.getId(), p2.getId());
//		assertEquals(p1.getName(), p2.getName());
//		assertEquals(p1.getSurname(), p2.getSurname());
//		assertEquals(p1.getPassword(), p2.getPassword());
//		if(!dao.delete(p1)) fail("can't delete");
//	}
//
//	@Test
//	public void testSave() {
//		Professor p1 = new Professor(100, "testSave", "testSave", "testSave"); 
//		if(!dao.save(p1)) fail("can't save");
//		Professor p2 = dao.getFromId(100);
//		assertEquals(Professor.class, p1.getClass());
//		assertEquals(Professor.class, p2.getClass());
//		assertEquals(p1.getId(), p2.getId());
//		assertEquals(p1.getName(), p2.getName());
//		assertEquals(p1.getSurname(), p2.getSurname());
//		assertEquals(p1.getPassword(), p2.getPassword());
//		if(!dao.delete(p1)) fail("can't delete");
//	}
//
//	@Test
//	public void testUpdate() {
//		if(!dao.save(new Professor(100, "testSave", "testSave", "testSave"))) fail("can't save");
//		
//		Professor p1 = new Professor(100, "testUpdate", "testUpdate", "testUpdate"); 
//		if(!dao.update(p1, new String[] {"100"})) fail("can't update");
//		assertEquals(p1.getId(), dao.getFromId(100).getId());
//		assertEquals("testUpdate", dao.getFromId(100).getName());
//		assertEquals("testUpdate", dao.getFromId(100).getSurname());
//		assertEquals("testUpdate", dao.getFromId(100).getPassword());
//		if(!dao.delete(p1)) fail("can't delete");
//	}
//
//	@Test
//	public void testDelete() {
//		if(!dao.save(new Professor(100, "testSave", "testSave", "testSave"))) fail("can't save");
//		Professor p1 = dao.getFromId(100);
//		assertNotNull(p1);
//		if(!dao.delete(p1)) fail("can't delete");
//		assertNull(dao.getFromId(100));
//	}
}
