package basicSeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecuterTesting {

	WebDriver driver;

	public void test() {

		WebElement element = driver.findElement(By.id("id_of_element"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,350)");

		WebElement element1 = driver.findElement(By.id("my-id"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();

		actions.click();

		element1.click();

		WebElement m = driver.findElement(By.linkText("Company"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", m);

	}

}
