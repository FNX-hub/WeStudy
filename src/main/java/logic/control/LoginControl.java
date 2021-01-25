package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.model.User;
import logic.model.bean.LoginBean;
import logic.model.bean.Session;
import logic.model.dao.DaoFactory;

//public class LoginBean extends HttpServlet

//@author Simone
public class LoginControl {
	
	public LoginControl() {
		SimpleLogger.info("LoginControl creato con successo");
	}
	
	//Utilizzato nell'applicazione web
	public String verifyUserWeb(LoginBean bean) {
		
		//Parametri ricevuti
		Integer id = bean.getId();
		String password = bean.getPassword();
		
		User extractedUser;
		
		SimpleLogger.info("[" + id + "] [" + password + "]");
		
		try {
			//Cerca tra i professori
			extractedUser = DaoFactory.getProfessorDao().getFromId(id);
			if(extractedUser.getPassword().equals(password)) {
				return "Professor";
			}
			
			//Cerca tra gli studenti
			extractedUser = DaoFactory.getStudentDao().getFromId(id);
			if(extractedUser.getPassword().equals(password)) {
				return "Student";
			}
			
			//Cerca tra i genitori
			extractedUser = DaoFactory.getParentDao().getFromId(id);
			if(extractedUser.getPassword().equals(password)) {
				return "Parent";
			}
		}
		catch(NullPointerException e) {
			return "ERROR";
		}
		
		return "ERROR";
	}
	
	//Utilizzato nell'applicazione standAlone
	public String verifyUser(LoginBean bean) {
		List<User> userList = new ArrayList<>();
		userList.add(DaoFactory.getProfessorDao().getFromId(bean.getId()));
		userList.add(DaoFactory.getParentDao().getFromId(bean.getId()));
		userList.add(DaoFactory.getStudentDao().getFromId(bean.getId()));
		for(User user : userList) {
			if(user.getPassword().equals(bean.getPassword())) {
				String session = String.format("%d:%s", user.getId(), user.getName());
				Session.getIstance().addSession(session, user);
				return session;
			}
		}
		return null;
	}
}
//	public LoginControl(){
//		System.err.println("[DEBUG]: LoginControl creato con successo");
//	}
//	
//	/*
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
//			 throws ServletException, IOException { 
//
//			 // reading the user input  
//			 String text1= request.getParameter("insertedUsername");
//			 System.out.println(text1);
//			 }
//	*/
//	
//	public static String tryLogin(String username,String password) {
//		LoginBeanWeb loginBean = new LoginBeanWeb(username,password); //Utilizza un bean per un controllo sintattico dei campi ricevuti e per convertirli
//		//TODO dialoga con il DAO per verificare se tale utente esiste
//		System.err.println("[DEBUG]: LoginControl>username: " + username);
//		System.err.println("[DEBUG]: LoginControl>password: " + password);
//		System.err.println("[DEBUG]: LoginBeanWeb>username: " + loginBean.getInsertedUsername());
//		System.err.println("[DEBUG]: LoginBeanWeb>password: " + loginBean.getInsertedPassword());
//
//		//TODO STUB - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//		/*
//		if(loginBean.getInsertedUsername().equals("Emperor")) {
//			loginBean.setRole("Professor");
//		}
//		else if(username.equals("Zero")) {
//			loginBean.setRole("Parent");
//		}
//		else if(username.equals("Adriano")) {
//			loginBean.setRole("Student");
//		}
//		else{
//			loginBean.setRole("NoUser");
//		}
//		*/
//		loginBean.setRole("Professor");
//		String dbPassword = "12345";
//		//STUB - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//		
//		//controlla se la password inserita NON corrisponde a quella memorizzata nel database
//		if(!(loginBean.getInsertedPassword().equals(dbPassword))) {
//			System.err.println("[DEBUG]: LoginControl: Error ---> Wrong Password");
//			loginBean.setRole("WrongPassword");
//		}
//		return loginBean.getRole();
//		
//	}
//}
