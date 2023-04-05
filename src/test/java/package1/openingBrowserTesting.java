package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openingBrowserTesting {

	public static void main(String[] args) {
		
		// declare the driver object
		WebDriver driver;
		
		// setting the chromedriver path
		System.setProperty("webdriver.chrome.driver",
				"/Users/hannah/Automation_Testing_Tools/chromedriver_mac_arm64/chromedriver");
		
		// instantiated web driver to chrome driver
		driver = new ChromeDriver();
		
		String url = "https://www.techcircleschool.com/";
		
		driver.get(url);

	}

}
