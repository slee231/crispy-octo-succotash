package basicSeleniumTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTestingExamples {
	
	WebDriver driver;

	@Before
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	@Ignore
	@Test
	public void firstAlert() {
		
		driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Alert')]")).click();
		
		String jsText2 = driver.switchTo().alert().getText();
		
		System.out.println(jsText2);
		
		driver.switchTo().alert().accept();
		
	}
	
	
	@Ignore
	@Test
	public void secondAlert() {
		
		driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Confirm')]")).click();
		
		String jsText = driver.switchTo().alert().getText();
		
		System.out.println(jsText);
		
		driver.switchTo().alert().accept();
		
	}
	
	
	@Test
	public void thirdAlert() {
		// pressing the alert button (blue button)
		driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Prompt')]")).click();
		
		// getting the text of the alert box and pring it out
		String jsText3 = driver.switchTo().alert().getText();
		System.out.println(jsText3);
		
		// sending string word to the alert box and accepting the alert
		String sendingString = "Rabbit";
		driver.switchTo().alert().sendKeys(sendingString);
		driver.switchTo().alert().accept();
		
		String actualResultFromThePage = driver.findElement(By.xpath("//*[@id = 'result']")).getText();
		Assert.assertTrue(actualResultFromThePage.contains(sendingString));
		
	}
	
	
	@After
	public void afterTest() {
//		driver.close();		
	}
	

}
