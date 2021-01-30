package test.deliverable;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import logic.control.RecoverUserInformation;
import logic.control.SimpleLogger;
import logic.model.bean.StudentBean;
import logic.model.bean.UserBean;

//@author Adriano

//TEST
//Dato un Parent -> Restituisci TUTTI i suoi figli Student
public class ParentSimpleTest {
	
	//utente non esistente
	@Test
	public void getAllChildren01(){
		//Crea un bean fittizio
		UserBean parentBean = new UserBean(1000);
		
		//Variabili di controllo
		Integer expectedNumOfChildren = 0;
		
		//Esegui il caso d'uso
		RecoverUserInformation controller = new RecoverUserInformation();
		List<StudentBean> children = controller.getAllChildren(parentBean);
		
		//Stampa di controllo
		Integer actualNumOfChildren = children.size();
		SimpleLogger.info("DEBUG: questo Parent ha N figli/figlie: " + actualNumOfChildren );
		for(int i=0 ; i<actualNumOfChildren; i++) {
			SimpleLogger.info(">>>" + i + "/" + children.get(i).getId()  + "/" + children.get(i).getName()  + "/" +  children.get(i).getSurname());
		}
		
		//Controllo
		assertEquals(expectedNumOfChildren, actualNumOfChildren);
	}
	
	//utente esistente e con figli/figlie
	@Test
	public void getAllChildren02() {
		//Crea un bean fittizio
		UserBean parentBean = new UserBean(1);
				
		//Variabili di controllo
		Integer expectedNumOfChildren = 2;
				
		//Esegui il caso d'uso
		RecoverUserInformation controller = new RecoverUserInformation();
		List<StudentBean> children = controller.getAllChildren(parentBean);

		Integer actualNumOfChildren = children.size();
				
		//Controllo
		assertEquals(expectedNumOfChildren, actualNumOfChildren);
	}
	
	//utente esistente senza figli (caso limite)
	@Test
	public void getAllChildren03() {
		//Crea un bean fittizio
		UserBean parentBean = new UserBean(8);
						
		//Variabili di controllo
		Integer expectedNumOfChildren = 0;
						
		//Esegui il caso d'uso
		RecoverUserInformation controller = new RecoverUserInformation();
		List<StudentBean> children = controller.getAllChildren(parentBean);
						
		//Stampa di controllo
		Integer actualNumOfChildren = children.size();
		SimpleLogger.info("trovati figli/figlie: N: " + actualNumOfChildren );
		for(int i=0 ; i<actualNumOfChildren; i++) {
			SimpleLogger.info(children.get(i).getName()  + "/" +  children.get(i).getSurname());
		}
						
		//Controllo
		assertEquals(expectedNumOfChildren, actualNumOfChildren);
	}
}
