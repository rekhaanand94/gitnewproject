package assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukriProject {
	WebDriver d;
	public void Loginpage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rekha\\Desktop\\chromedriver_win32 (1)\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.get("https://www.naukri.com/nlogin/logout");
		d.findElement(By.xpath("//input[@id='usernameField']")).sendKeys("rekhaganesh95@gmail.com");
		d.findElement(By.xpath("//input[@id='passwordField']")).sendKeys("charuganesh");
		d.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(3000);
		
	}
	public void uploadresume() throws InterruptedException, IOException{
		
		d.findElement(By.xpath("//a[text()='UPDATE PROFILE']")).click();
		d.findElement(By.xpath("//input[@id='attachCV']")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\rekha\\Desktop\\resumeupload.exe");
		System.out.println("The Resume has been successfully uploaded");
		
		
	}
	
	public void AddDetails() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)d;
		jse.executeScript("window.scrollBy(0,1800)","");
		d.findElement(By.xpath("/html/body/div[2]/div/div/span/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div/div[1]/span[3]")).click();
		d.switchTo().activeElement();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//input[@class='srchTxt'])[1]")).sendKeys("2");
		d.findElement(By.xpath("(//input[@class='srchTxt'])[2]")).sendKeys("Mar");
		d.findElement(By.xpath("(//input[@class='srchTxt'])[3]")).sendKeys("1994");
		d.findElement(By.xpath("(//label[@class='radio-lbl'])[2]")).click();
		d.findElement(By.id("pd-maritalStatusFor")).click();
		
		d.findElement(By.xpath("//input[@id='pd-pincode']")).sendKeys("560066");
		Thread.sleep(2000);
				
	}
	 public void teardown(){
		d.close();
		
	 }

public static void main(String[] args) throws InterruptedException, IOException {
	 NaukriProject ref = new  NaukriProject();
	 ref.Loginpage();
	ref.uploadresume();
	ref.teardown();
	// ref.AddDetails();
	
	 
	 

	}

}