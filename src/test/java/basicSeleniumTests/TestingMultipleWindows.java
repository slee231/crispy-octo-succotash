package basicSeleniumTests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingMultipleWindows {

	WebDriver driver;

	@Before
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void testAll() {
		newTab();
		newWindow();
		newWindowMessage();
	}

	public void newTab() {

		driver.findElement(By.xpath("//*[@id='tabButton']")).click();
		System.out.println("1. Title before switching to child - " + driver.getTitle());

		Set<String> tabsIds = driver.getWindowHandles();
		Iterator<String> it = tabsIds.iterator();
		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);

		String text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);

		driver.switchTo().window(parentId);

		System.out.println("1. Title after Switching back to parentWindow - " + driver.getTitle());
	}

	public void newWindow() {

		driver.findElement(By.xpath("//*[@id='windowButton']")).click();
		System.out.println("2. Title before switching to child - " + driver.getTitle());

		Set<String> tabsIds = driver.getWindowHandles();
		Iterator<String> it = tabsIds.iterator();
		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);

		String text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);

		driver.switchTo().window(parentId);

		System.out.println("2. Title after Switching back to parentWindow - " + driver.getTitle());
	}

	public void newWindowMessage() {
		// clicking on the tab button and getting the title of the parent window before
		// switching
		driver.findElement(By.xpath("//*[@id='messageWindowButton']")).click();
		System.out.println("3. Title before switching to child - " + driver.getTitle());

		Set<String> tabsIds = driver.getWindowHandles();
		Iterator<String> it = tabsIds.iterator();
		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);

		String text = driver.findElement(By.xpath("/html/body")).getText();
		System.out.println(text);

		driver.switchTo().window(parentId);
		System.out.println("3. Title after Switching back to parent tab - " + driver.getTitle());
	}
	
	
	@After
	public void afterTest() {
		driver.close();
	}


}
