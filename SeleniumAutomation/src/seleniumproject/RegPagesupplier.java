package seleniumproject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegPagesupplier {
	public static WebDriver driver;
	

	@BeforeTest
	public void signup() throws InterruptedException, AWTException{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rekha\\Desktop\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://18.224.140.205/supplier/register");
		Thread.sleep(9000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Rekha");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("G");
		String alert = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getAttribute("INNERHTML");
		System.out.println(alert);
		rb.keyPress(KeyEvent.VK_BACK_SPACE);
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Ganesh");
		
		driver.findElement(By.xpath("//input[@name='bank']")).sendKeys("XYZ");
		
		WebElement busph = driver.findElement(By.xpath("//select[@name='home_phone_country_code']"));
		
		Select sel = new Select(busph);
		sel.selectByIndex(100);
		
		driver.findElement(By.xpath("//input[@name='home_phone']")).sendKeys("9483806295");
		
	    driver.findElement(By.xpath("//input[@name='work_phone']")).sendKeys("9739792440");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("rekhaganesh95@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='fax']")).sendKeys("12345567");
		
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Ramagoundhanahalli");
		
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		
		Select sel1 = new Select(country);
		sel1.selectByVisibleText("India");
		
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("560066");
		WebDriverWait  wait= new WebDriverWait(driver,10);
		WebElement element  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='recaptcha-checkbox-border']")));
		driver.findElement(By.xpath("//input[@name='termsAndCondition']")).click();
		
	}
	
	@Test
	public void verify(){
		driver.findElement(By.xpath("//button[@name='submit']")).click();
	String title = 	driver.getTitle();
	Assert.assertEquals(title,"Home page");
		
		
	}
	
	
	
	
	
	@AfterTest
		public void Logout(){
			
		
		driver.close();
		}
		
		
		
		
		
		
		

	}


