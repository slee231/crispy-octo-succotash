package fiftyOneTestCases.no3_myAccount;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class No5_AddressFunctionality1 {

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
	public void AddressFunc1() {
//		3) Click on My Account Menu
		WebElement myAccount13 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount13.click();
//		refreshing to bypass the ads popup
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		
//		4) Enter registered username in username textbox
		WebElement userNameBox13 = driver.findElement(By.xpath("//*[@id='username']"));
		userNameBox13.clear();
		userNameBox13.sendKeys("testing321@gmail.com");
		
//		5) Enter password in password textbox
		WebElement pwdBox13 = driver.findElement(By.xpath("//*[@id='password']"));
		pwdBox13.clear();
		pwdBox13.sendKeys("testemail321.");
		
//		6) Click on login button
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
//		7) User must successfully login to the web page
		   // ------ usccessfully login and land on My Account --> Dashboard
		
//		8) Click on Myaccount link which leads to Dashboard
		   // No need to click Myaccount
		
//		9) Click on Orders link
		
//		10) User must view their orders on clicking orders link
		driver.findElement(By.xpath("//a[text()='Orders']")).click();
		// Just in case ad pops up again
		driver.navigate().refresh();
	}
	
	
	@After
	public void closeBrowser() {
		driver.close();
	}

}
