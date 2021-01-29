package testTrani;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import logic.control.SimpleLogger;

import static org.junit.Assert.assertEquals;



//@author Adriano
public class Selenium {
	
	//NB questo test funziona soltanto in locale con il sito e il database attivi su localhost:8080
	//Date le corrette credenziali di accesso di uno studente, 
	//	controlla se il login viene effettuato con successo
	//	controlla se la pagina caricata sia quella corrispondente al ruolo dell'utente
	@Test
	public void LoginTest() throws InterruptedException{
		
		//Variabili di controllo
		Integer expectedSuccesses = 2;
		Integer actualSuccesses = 0;
		
		//Inizializza il driver
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Apri la pagina su cui lavorare
		driver.get("http://localhost:8080/WeStudy/"); 
		
		//Scrivi dentro la textbox dello username
		driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys("1");
		
		//Scrivi dentro la textbox della password
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys("1234");
		
		Thread.sleep(500);
		
		//Clicca il bottone del login
		driver.findElement(By.xpath("/html/body/div/div/form/button")).click(); 
		
		//Recupera il risultato nella pagina di riepilogo
		WebElement txtBoxContent = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td"));
		
		//Convertilo in un formato adeguato per Junit
		String stringBoxContent = txtBoxContent.getText();
		
		//Stampa di controllo
		SimpleLogger.info("VALORE ESTRATTO: <" + stringBoxContent + ">");
		
		Thread.sleep(500);
		
		//Clicca sul bottone per caricare la mainPage
		driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td/a/b")).click(); 
		
		//Recupera il risultato sulla navbar
		WebElement txtNavbarContent = driver.findElement(By.xpath("/html/body/div/div/div/b"));
		
		//Convertilo in un formato adeguato per Junit
		String stringNavbarContent = txtNavbarContent.getText();
		
		//Stampa di controllo
		SimpleLogger.info("NAVBAR: <" + stringNavbarContent + ">");
		
		//Chisura del driver - se lo metti dopo assertEquals NON verrà eseguito
		driver.close(); 
		
		//>>>Parte di JUnit
		
		//Controllo sui valori ricevuti
		if(stringBoxContent.contains("Student")) {
			actualSuccesses++;
		}
		if(stringNavbarContent.contains("Student")) {
			actualSuccesses++;
		}
		
		//assert
		assertEquals(expectedSuccesses, actualSuccesses); 
		
	}
}
