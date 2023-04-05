package web_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindLocators {

	public static void main(String[] args) throws InterruptedException {
		// id = "twotabsearchtextbox" --> Amazon search box element
		
		String url = "https://www.amazon.com/";
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		driver.get(url);
		
		
		// To find a single element, must use the 'findElement' method from the driver and declare
		// the attribute type using 'By.id' / 'By.ClassName' etc. and pass the leement value from the UI
		// WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		
		
		Thread.sleep(3000); // DO NOT "Thread.sleep()" on the job. Everyone hates it
		
		// This method will clear the search box, just in case if there is any value
		searchBox.clear();
		
		//this method willl sendKeys (write some values in the box)
		String product = "laptop";
		searchBox.sendKeys("product");
		
		// id = "nav-search-submit-button" --> searchButton
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		
		searchButton.click();
		
		
		if (driver.getTitle().equals("Amazon.com : " + product)) {
			System.out.println("You are searching the right product: " + product);
		} else {
			System.out.println("You are searching something else and the title is " + product);
		}
		
		
		driver.quit();
		

	}

}
