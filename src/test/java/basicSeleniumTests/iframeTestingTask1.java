package basicSeleniumTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframeTestingTask1 {

	WebDriver driver;
	Actions action;

	@Before
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    
    @Test
    public void task1() {
        
        driver.switchTo().frame(0);
                
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Fascinating, Hannah!");
        String stringtext = driver.findElement(By.id("tinymce")).getText();
        	System.out.println(stringtext);
            
        driver.switchTo().defaultContent();
    }
    
	
	
    @After
    public void afterTest() {
    	driver.close();
    }
	
}
