package dummyTest;


import java.util.List;


import logic.model.Assignment;

import logic.model.dao.DaoFactory;


public class DummyViewAssignmentTest {
	
	public static void main(String[] args) {
		
		List<Assignment> listaTemp = DaoFactory.getAssignmentDao().getAll();
		
		for(int i=0 ; i<listaTemp.size() ; i++) {
			System.out.print("Desc> " + listaTemp.get(i).getDescription());
			System.out.print("Crea> " + listaTemp.get(i).getCreationDate());
			System.out.println("Dead> " + listaTemp.get(i).getDeadlineDate());
			
		}
		
	}
}
