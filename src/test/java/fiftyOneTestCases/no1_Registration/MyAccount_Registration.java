package fiftyOneTestCases.no1_Registration;

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

public class MyAccount_Registration {
	
	WebDriver driver;
	String url;

	@Before
	public void openBrowser() {
		
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		url = "http://practice.automationtesting.in/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	
	@Ignore
	@Test
	public void registerSignIn() {

//		3) Click on My Account Menu
		WebElement myAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount.click();

//		refreshing to bypass the ads popup
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		
//		4) Enter registered Email Address in Email-Address textbox
		WebElement emailTextBox = driver.findElement(By.xpath("//*[@id='reg_email']"));
		emailTextBox.sendKeys("testing321@gmail.com");
		
//		5) Enter your own password in password textbox
		WebElement pwdTextBox = driver.findElement(By.xpath("//*[@id='reg_password']"));
		pwdTextBox.sendKeys("testemail321.");
		
//		6) Click on Register button
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
//		7) User will be registered successfully and will be navigated to the Home page
	
	}
	
	
	@Ignore
	@Test
	public void registerWithInvalidEmail() {

//		3) Click on My Account Menu
		WebElement myAccount2 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount2.click();

//		refreshing to bypass the ads popup
		driver.navigate().refresh();

//		driver.findElement(By.xpath("//a[text()='My Account']")).click();  //<-- this line alone doesn't work. Need line 77 & 78
		myAccount2 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount2.click();
		
//		4) Enter invalid Email Address in Email-Address textbox
		WebElement emailTextBox2 = driver.findElement(By.xpath("//*[@id='reg_email']"));
		emailTextBox2.sendKeys("2@f.c");
		
//		5) Enter your own password in password textbox
		WebElement pwdTextBox2 = driver.findElement(By.xpath("//*[@id='reg_password']"));
		pwdTextBox2.sendKeys("testemail321.");
		
//		6) Click on Register button
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
//		7) Registration must fail with a warning message(ie You must enter a valid email address)
	
	}
	
	
	@Ignore
	@Test
	public void registerWithEmptyEmail() {

//		3) Click on My Account Menu
		WebElement myAccount3 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount3.click();

//		refreshing to bypass the ads popup
		driver.navigate().refresh();
		
		myAccount3 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount3.click();
		
//		4) Enter invalid Email Address in Email-Address textbox
		WebElement emailTextBox3 = driver.findElement(By.xpath("//*[@id='reg_email']"));
		emailTextBox3.sendKeys("");
		
//		5) Enter your own password in password textbox
		WebElement pwdTextBox3 = driver.findElement(By.xpath("//*[@id='reg_password']"));
		pwdTextBox3.sendKeys("testemail321.");
		
//		6) Click on Register button
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
//		7) Registration must fail with a warning message(ie please provide valid email address)

	}
	
	

	@Ignore
	@Test
	public void registerWithEmptyPwd() {

//		3) Click on My Account Menu
		WebElement myAccount4 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount4.click();

//		refreshing to bypass the ads popup
		driver.navigate().refresh();
		
		myAccount4 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount4.click();
		
//		4) Enter valid Email Address in Email-Address textbox
		WebElement emailTextBox4 = driver.findElement(By.xpath("//*[@id='reg_email']"));
		emailTextBox4.sendKeys("testing32123@gmail.com");
		
//		5) Enter empty password in password textbox
		WebElement pwdTextBox4 = driver.findElement(By.xpath("//*[@id='reg_password']"));
		pwdTextBox4.sendKeys("");
		
//		6) Click on Register button
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
//		7) Registration must fail with a warning message(ie please enter an account password)

	}
	
	@Ignore
	@Test
	public void registerWithEmptyEmailAndPwd() {

//		3) Click on My Account Menu
		WebElement myAccount5 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount5.click();

//		refreshing to bypass the ads popup
		driver.navigate().refresh();
		
		myAccount5 = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount5.click();
		
//		4) Enter empty Email Address in Email-Address textbox
		WebElement emailTextBox5 = driver.findElement(By.xpath("//*[@id='reg_email']"));
		emailTextBox5.sendKeys("");
		
//		5) Enter empty password in password textbox
		WebElement pwdTextBox5 = driver.findElement(By.xpath("//*[@id='reg_password']"));
		pwdTextBox5.sendKeys("");
		
//		6) Click on Register button
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
//		7) Registration must fail with a warning message(ie please provide a valid email address)

	}
	
	
	@After
	public void closeBrowser() {
		driver.close();
	}

}
