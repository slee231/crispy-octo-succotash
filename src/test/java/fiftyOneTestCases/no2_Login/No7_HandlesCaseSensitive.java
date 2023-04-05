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

public class No7_HandlesCaseSensitive {

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
	public void loginHandlesCaseSensitive() {
//		3) Click on My Account Menu
		WebElement myAccount7 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount7.click();
//		refreshing to bypass the ads popup
		driver.navigate().refresh();
		myAccount7 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount7.click();
		
//		4) Enter the case changed username in username textbox
		WebElement userNameBox7 = driver.findElement(By.xpath("//*[@id='username']"));
		userNameBox7.sendKeys("TesTing321@gmail.com");
		
//		5) Enter the case changed password in the password tetxbox
		WebElement pwdBox7 = driver.findElement(By.xpath("//*[@id='password']"));
		pwdBox7.sendKeys("tesTemail321.");
		
//		6) Now click on login button
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
//		7) Login must fail saying incorrect username/password
		
	}
	

	@After
	public void closeBrowser() {
		driver.close();
	}

}
