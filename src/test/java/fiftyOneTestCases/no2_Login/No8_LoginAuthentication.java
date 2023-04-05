package fiftyOneTestCases.no2_Login;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class No8_LoginAuthentication {
	
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
	public void loginAuthendication() {
//		3) Click on My Account Menu
		WebElement myAccount8 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount8.click();
//		refreshing to bypass the ads popup
		driver.navigate().refresh();
		myAccount8 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount8.click();
		
//		4) Enter the case changed username in username textbox
		WebElement userNameBox8 = driver.findElement(By.xpath("//*[@id='username']"));
		userNameBox8.sendKeys("testing321@gmail.com");
		
//		5) Enter the case changed password in the password tetxbox
		WebElement pwdBox8 = driver.findElement(By.xpath("//*[@id='password']"));
		pwdBox8.sendKeys("testemail321.");
		
//		6) Now click on login button
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
//		7) Once your are logged in, sign out of the site
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		
//		8) Now press back button
		driver.navigate().back();
		
//		9) User shouldn’t be signed in to his account rather a general webpage must be visible
		
	}
	
	
	@After
	public void closeBrowser() {
		driver.close();
	}

}
