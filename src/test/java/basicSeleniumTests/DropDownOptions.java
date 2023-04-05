package basicSeleniumTests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownOptions {

	WebDriver driver;
	Select select;

	@Before
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dropdown");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void dropOption() throws InterruptedException {

		Thread.sleep(2000);

		select = new Select(driver.findElement(By.id("dropdown")));

		select.selectByValue("2");

		Thread.sleep(3000);

		select.selectByIndex(1);

		Thread.sleep(3000);

		select.selectByVisibleText("Please select an option");

	}

}
