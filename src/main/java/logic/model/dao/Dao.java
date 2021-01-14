package logic.model.dao;

import java.util.List;


/**
 * @author Simone
 */
public interface Dao<T> {
	
	public List<T>getAll();
	
	public void save(T t);
	
	public void update(T t, String[] pkeys);
	
	public void delete(T t);
}