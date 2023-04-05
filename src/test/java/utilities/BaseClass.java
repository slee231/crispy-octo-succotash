package utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	private static WebDriver driver;
	
	
	//when return type is "WebDriver" it returns a "driver"  ex) Chromedriver, Firefoxdriver, Operadriver etc.
	
	//Driver instantiation function
	public static WebDriver getDriver() {
		
		if (driver == null) {
			
			switch(BaseClass.getProperty("browser")) {
			
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "chrome-headless":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				
			case "firefox-headless":
				WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
				break;
			
			case "edge":
				if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
					throw new WebDriverException("Your OS doesn't support EDGE");
				}
				WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
				
			case "safari":
				if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
					throw new WebDriverException("Your OS doesn't support Safari");
				}
				WebDriverManager.getInstance(SafariDriver.class).setup();
                driver = new SafariDriver();
                break;
			
			}
			
			driver.get(BaseClass.getProperty("url"));
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		}
		
		
		return driver;
	}
	
	
	
	public static void closeDriver() {
		
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	
	// config reader function
	// must instantiate the "configFile"
	private static Properties configFile;  // "Properties" is class  "configFile" is an object(name) you create
	
	static {
		
		try {
			// ************   THIS IS THE ONLY LINE THAT WILL CHANGE   ************
			String filePath = "src/test/resources/files/config.properties";
			FileInputStream input = new FileInputStream(filePath);
			
			configFile = new Properties();
			configFile.load(input);
			
			
			input.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static String getProperty(String keyName) {
		
		return configFile.getProperty(keyName);
		
	}
	

}
