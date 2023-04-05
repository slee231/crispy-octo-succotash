package fiftyOneTestCases.no2_Login;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class No1_WithValidUserNameAndPassword {
	
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
	public void loginWithValidUserNameAndPwd() {
//		3) Click on My Account Menu
		WebElement myAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount.click();
//		refreshing to bypass the ads popup
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		
//		4) Enter registered username in username textbox
		WebElement userNameBox = driver.findElement(By.xpath("//*[@id='username']"));
		userNameBox.sendKeys("testing321@gmail.com");
		
//		5) Enter password in password textbox
		WebElement pwdBox = driver.findElement(By.xpath("//*[@id='password']"));
		pwdBox.sendKeys("testemail321.");
		
//		6) Click on login button
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
//		7) User must successfully login to the web page
		
	}
	
	
	@After
	public void closeBrowser() {
		driver.close();
	}

}
