package basicSeleniumTests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicOptionsTesting {

	WebDriver driver;
	Select select;

	@Before
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void dynamicDropDown() {
//
//		WebElement fromCity = driver.findElement(By.id("fromCity"));
//		fromCity.click();
//		fromCity.sendKeys("iad");

		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("IAD");
		driver.findElement(By.xpath("//div[text()='IAD']")).click();

	}

}
