package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.model.Parent;
import logic.model.dao.DaoFactory;
import logic.model.dao.ParentDao;

/**
 * @author Simone
 */
public class ParentDaoTest {

	private final ParentDao dao = DaoFactory.getParentDao();
	
	@Test
	public void testGetAll() {
		List<Parent> parentList = new ArrayList<>(); 
		assertEquals(parentList.getClass(), dao.getAll().getClass());
	}

	@Test
	public void testGetFromId() {
		Parent p1 = new Parent(100, "geId", "getId", "getId", "getId");
		dao.save(p1);
		Parent p2 = dao.getFromId(100);
		assertEquals(Parent.class, p2.getClass());
		assertEquals(p1.getId(), p2.getId());
		assertEquals(p1.getName(), p2.getName());
		assertEquals(p1.getSurname(), p2.getSurname());
		assertEquals(p1.getPassword(), p2.getPassword());
		assertEquals(p1.getPhoneNumber(), p2.getPhoneNumber());
		dao.delete(p1);
	}

	@Test
	public void testSave() {
		Parent p1 = new Parent(100, "testSave", "testSave", "testSave", "testSave"); 
		dao.save(p1);
		Parent p2 = dao.getFromId(100);
		assertEquals(Parent.class, p1.getClass());
		assertEquals(Parent.class, p2.getClass());
		assertEquals(p1.getId(), p2.getId());
		assertEquals(p1.getName(), p2.getName());
		assertEquals(p1.getSurname(), p2.getSurname());
		assertEquals(p1.getPassword(), p2.getPassword());
		assertEquals(p1.getPhoneNumber(), p2.getPhoneNumber());
		dao.delete(p1);
	}

	@Test
	public void testUpdate() {
		dao.save(new Parent(100, "testSave", "testSave", "testSave", "testSave"));
		
		Parent p1 = new Parent(100, "testUpdate", "testUpdate", "testUpdate", "testUpdate"); 
		dao.update(p1, new String[] {"100"});
		assertEquals(p1.getId(), dao.getFromId(100).getId());
		assertEquals("testUpdate", dao.getFromId(100).getName());
		assertEquals("testUpdate", dao.getFromId(100).getSurname());
		assertEquals("testUpdate", dao.getFromId(100).getPassword());
		assertEquals("testUpdate", dao.getFromId(100).getPhoneNumber());
		dao.delete(p1);
	}

	@Test
	public void testDelete() {
		dao.save(new Parent(100, "testSave", "testSave", "testSave", "testSave"));
		Parent p1 = dao.getFromId(100);
		assertNotNull(p1);
		dao.delete(p1);
		assertNull(dao.getFromId(100));
	}
}
