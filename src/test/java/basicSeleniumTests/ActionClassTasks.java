package basicSeleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassTasks {
	
	WebDriver driver;
	Actions action;

	@Before
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.get("https://amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void mouseOver() throws InterruptedException {
		
		// hover over "Account & Lists" block
		action.moveToElement(driver.findElement(By.xpath("//div[@id='nav-tools']/a[2]"))).build().perform();
		Thread.sleep(2000);
				
		// create and store tabs names (web elements) into a list
		List<WebElement> tabs = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
		
		// loop through and go over each tab in the list
		for (WebElement tab : tabs) {
			
			// if prime tab is found, execute the below action
			if (tab.getText().contains("Prime")) {
				// hover over "Prime" block
				action.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-amazonprime']"))).build().perform();
				
				Thread.sleep(2000);
			}
		}
		
	}
	
	
	@Ignore
	@After
	public void afterTest() {
		driver.close();
	}
	

}
