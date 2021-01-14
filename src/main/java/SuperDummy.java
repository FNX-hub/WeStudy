import java.sql.DriverManager;
import java.sql.SQLException;

public class SuperDummy {

	//Una semplice STUB utilizzata per controllare l'interazione con il database
	public static void main(String[] args) {
		try {
			DriverManager.getConnection("jdbc:mysql://localhost/westudy","root","");
			//westudy è il nome del db su phpMyAdmin
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
