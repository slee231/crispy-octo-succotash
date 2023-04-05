package basicSeleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListOfElementsClickTask {

	WebDriver driver;

	@Before
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void clickDroppable() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> interactionsSideBar = driver.findElements(By.xpath("//div[@id='sidebar']/aside/ul/li"));
		
		for (WebElement eachLink : interactionsSideBar) {
			
			if (eachLink.getText().contains("Droppable")) {
				eachLink.click();
				break;
			}
		}
	}
	
	
	@After
	public void afterTest() {
		driver.close();
	}

	
	
}
