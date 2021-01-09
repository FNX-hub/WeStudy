package logic.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginBean extends HttpServlet{

	private static String insertedUsername;
	private static String insertedPassword;
	private static String role;
	
	public LoginBean(){
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException { 

			 // reading the user input  
			 String text1= request.getParameter("insertedUsername");
			 System.out.println(text1);
			 }
	
	
	public static String getInsertedUsername() {
		return insertedUsername;
	}
	public static String getInsertedPassword() {
		return insertedPassword;
	}
	public static void setInsertedUsername(String inserted) {
		insertedUsername = inserted;
	}
	public static void setInsertedPassword(String inserted) {
		insertedPassword = inserted;
	}
	
	public static String tryLogin(String username,String password) {
		String returnedRole;
		//TODO dialoga con il DAO per verificare le credenziali ricevute e stabilire il ruolo 
		if(username.equals("Emperor")) {
			returnedRole = "Professor";
		}
		else if(username.equals("Zero")) {
			returnedRole = "Student";
		}
		else {
			returnedRole = "Error: User not found";
		}
		return returnedRole;
	}
	

	public static String getRole() {
		return role;
	}


	public static void setRole(String role) {
		LoginBean.role = role;
	}
	
	public static Integer dumb() {
		return 39;
	}
	
	public static String nothing() {
		//La totale inutilita'
		return "[STRINGA DI DEBUG](VAQP)";
	}
	
}
