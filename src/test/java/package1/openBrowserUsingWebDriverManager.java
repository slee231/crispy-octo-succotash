package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openBrowserUsingWebDriverManager {

	public static void main(String[] args) {

		// declare the driver object
		WebDriver driver;

		// setting the chromedriver path
		WebDriverManager.chromedriver().setup();

		// instantiated web driver to chrome driver
		driver = new ChromeDriver();

		String url = "https://www.techcircleschool.com/";

		driver.get(url);

	}

}
