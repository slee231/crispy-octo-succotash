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

public class No2_WithIncorrectUserNameAndPassword {
	
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
	public void loginWithIncorrectUserNameAndIncorrectPwd() {
//		3) Click on My Account Menu
		WebElement myAccount2 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount2.click();
//		refreshing to bypass the ads popup
		driver.navigate().refresh();
		
		myAccount2 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount2.click();
		
//		4) Enter incorrect username in username textbox
		WebElement userNameBox2 = driver.findElement(By.xpath("//*[@id='username']"));
		userNameBox2.sendKeys("1testing32@gmail.com");
		
//		5) Enter incorrect password in password textbox.
		WebElement pwdbox2 = driver.findElement(By.xpath("//*[@id='password']"));
		pwdbox2.sendKeys(".testemail321");
		
//		6) Click on login button
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
//		7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
		
	}
	

	@After
	public void closeBrowser() {
		driver.close();
	}

}
