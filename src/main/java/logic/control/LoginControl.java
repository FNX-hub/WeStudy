package logic.control;

import logic.model.bean.LoginBeanWeb;

//public class LoginBean extends HttpServlet
public class LoginControl{
	
	public LoginControl(){
		System.err.println("[DEBUG]: LoginControl creato con successo");
	}
	
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException { 

			 // reading the user input  
			 String text1= request.getParameter("insertedUsername");
			 System.out.println(text1);
			 }
	*/
	
	public static String tryLogin(String username,String password) {
		LoginBeanWeb loginBean = new LoginBeanWeb(username,password); //Utilizza un bean per un controllo sintattico dei campi ricevuti e per convertirli
		//TODO dialoga con il DAO per verificare se tale utente esiste
		System.err.println("[DEBUG]: LoginControl>username: " + username);
		System.err.println("[DEBUG]: LoginControl>password: " + password);
		System.err.println("[DEBUG]: LoginBeanWeb>username: " + loginBean.getInsertedUsername());
		System.err.println("[DEBUG]: LoginBeanWeb>password: " + loginBean.getInsertedPassword());

		//TODO STUB - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
		/*
		if(loginBean.getInsertedUsername().equals("Emperor")) {
			loginBean.setRole("Professor");
		}
		else if(username.equals("Zero")) {
			loginBean.setRole("Parent");
		}
		else if(username.equals("Adriano")) {
			loginBean.setRole("Student");
		}
		else{
			loginBean.setRole("NoUser");
		}
		*/
		loginBean.setRole("Professor");
		String dbPassword = "12345";
		//STUB - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
		
		//controlla se la password inserita NON corrisponde a quella memorizzata nel database
		if(!(loginBean.getInsertedPassword().equals(dbPassword))) {
			System.err.println("[DEBUG]: LoginControl: Error ---> Wrong Password");
			loginBean.setRole("WrongPassword");
		}
		return loginBean.getRole();
		
	}
}
