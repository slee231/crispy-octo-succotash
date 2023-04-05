package fiftyOneTestCases.no2_Login;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class No6_PasswordShouldBeMasked {
	
	WebDriver driver;
	String url;
	
	@Before
	public void openBrowswer() {
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		url = "http://practice.automationtesting.in/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

	
	@Test
	public void loginPwdShouldBeMasked() {
//		3) Click on My Account Menu
		WebElement myAccount6 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount6.click();
//		refreshing to bypass the ads popup
		driver.navigate().refresh();
		myAccount6 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount6.click();
		
//		4) Enter the password field with some characters
		WebElement pwdBox6 = driver.findElement(By.xpath("//*[@id='password']"));
		pwdBox6.sendKeys("test");
		
//		5) The password field should display the characters in asterisks or bullets such that 
//		the password is not visible on the screen
		
	}
	

	@After
	public void closeBrowser() {
		driver.close();
	}

}
