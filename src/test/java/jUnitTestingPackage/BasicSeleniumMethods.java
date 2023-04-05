package jUnitTestingPackage;

import java.awt.print.Pageable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicSeleniumMethods {
	
	WebDriver driver;
	
	@Before
	public void openBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void testingWebApplication() {
		
		// title of the page
		String title = driver.getTitle();
		
		// current URL
		String currentURL = driver.getCurrentUrl();
		
		// html dom
		String pageSource = driver.getPageSource();
		
		//System.out.println("The title of the page is ----> " + title);
		
		//System.out.println("The current URL of the page is ----> " + currentURL);
		
		System.out.println(pageSource);
		
	}
	
	
	@After
	public void closeBrowser() {
		
		driver.close();
		
	}
	
	
	

}
