package tuesdaySelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium1 {

	public static void main(String[] args) {

		String url;

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		// open google.com
		url = "https://www.google.com/";

		// navigate to the url you have passed
		driver.get(url);

		// driver.getTitle() --> will return the title of the page

		System.out.println("Title: " + driver.getTitle());
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";

		if (actualTitle.equals(expectedTitle) && driver.getCurrentUrl().equals(url)) {
			System.out.println("We are in " + url);
		} else {
			System.out.println("You are in different page: " + driver.getCurrentUrl());
		}

		
		url = "https://www.amazon.com/";
		// navigate you to the url you have passed. It is different than the
		// driver.get() !!!
		driver.navigate().to(url);

		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("We are in " + url);
		} else {
			System.out.println("You are in different page: " + driver.getCurrentUrl());
		}

		
		// navigate back to the previous page, in which our case is Google.com
		driver.navigate().back();

		if (driver.getCurrentUrl().equals("https://www.google.com/")) {
			System.out.println("We are in " + "https://www.google.com/");
		} else {
			System.out.println("You are in different page: " + driver.getCurrentUrl());
		}

		
		// navigate back to the forward page, in which our case is Amazon.com 
		driver.navigate().forward();

		if (driver.getCurrentUrl().equals("https://www.amazon.com/")) {
			System.out.println("We are in " + "https://www.amazon.com/");
		} else {
			System.out.println("You are in different page: " + driver.getCurrentUrl());
		}
		
		
		driver.quit();
		driver.close();

	}

}
