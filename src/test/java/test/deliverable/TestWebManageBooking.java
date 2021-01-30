package test.deliverable;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import logic.control.SimpleLogger;

/**
 * @author Simone
 */
public class TestWebManageBooking {

	private WebDriver driver;
	@Test
	public void ProfessorBookingWebTest() {
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		this.driver = new ChromeDriver();
			
		driver.get("http://localhost:8080/WeStudy/");
		driver.findElement(By.xpath("//*[@id=\"insertedUsername\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"insertedPassword\"]")).sendKeys("pr1");
		driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
		driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/a[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"start\"]")).sendKeys("01-01-2025");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form[1]/table/tbody/tr[2]/td[4]/input")).sendKeys("SELENIUMTEST");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form[1]/input")).submit();
		String result = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[2]")).getText();
		SimpleLogger.info(result);
		assertEquals("Meeting created with success", result);
		driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[3]/td/a")).click();;
		driver.findElement(By.xpath("/html/body/div[1]/div/div/a[5]")).click();
		result = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table[1]/tbody/tr[2]/td[6]")).getText();
		assertEquals("SELENIUMTEST", result);
		SimpleLogger.info(result);
	}
	@Test
	public void ProfessorDeleteBookingWebTest() {
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		this.driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/WeStudy/");
		driver.findElement(By.xpath("//*[@id=\"insertedUsername\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"insertedPassword\"]")).sendKeys("pr1");
		driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
		driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/a[5]")).click();
		
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form[2]/table/tbody/tr[2]/td/select")).sendKeys("1,1,2025-01-01");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form[2]/input")).submit();
		String result = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[2]")).getText();
		SimpleLogger.info(result);
		assertEquals("Delete request sent", result);
	}
	@After
	public void close() {
		driver.close();
	}
}
