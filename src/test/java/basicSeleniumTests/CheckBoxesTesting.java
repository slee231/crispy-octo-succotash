package basicSeleniumTests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxesTesting {
	
	WebDriver driver;
	
	@Before
	public void openBrower() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void test1() {
		
		WebElement checkBox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
		
		WebElement checkBox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
		
		Boolean isTrue1 = checkBox1.isSelected();
		
		Boolean isTrue2 = checkBox2.isSelected();
		
		if(isTrue1) {
            System.out.println("It is selected");
        }else {
            checkBox1.click();
        }
		
		if(isTrue2) {
            System.out.println("It is selected");
        }else {
            checkBox2.click();
        }
		
	}
	
	
	@Test
	public void test2() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")))).click();
		
		
	}
	

}
