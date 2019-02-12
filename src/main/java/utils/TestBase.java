package utils;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import dataProviders.ConfigFileReader;

public class TestBase {
	
    public static WebDriver driver;
    
	@BeforeTest
	public void setup() {
		
		String browserName=ConfigFileReader.getProperty("browserName");
		
		switch(browserName) {
			case "fireFox":
				System.setProperty("webdriver.gecko.driver","web-drivers/geckodriver.exe");
				FirefoxOptions opts = new FirefoxOptions().setLogLevel(FirefoxDriverLogLevel.TRACE);
				driver = new FirefoxDriver(opts);
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				break;
				
			case "chrome":
				System.out.println("in chrome browser");
				System.setProperty("webdriver.chrome.driver", "web-drivers/chromedriver-44.exe");
		       
				/*LoggingPreferences logPrefs = new LoggingPreferences();
		        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
				ChromeOptions opts1 = new ChromeOptions().setCsetCapability(CapabilityType.LOGGING_PREFS,logPrefs ); 
				*/
		        /*ChromeOptions chromeOptions = new ChromeOptions();
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		        LoggingPreferences logPrefs = new LoggingPreferences();
		        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		        */
		        
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				
				break;
			
			default:
				System.out.println("Invalid Browser type");
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
