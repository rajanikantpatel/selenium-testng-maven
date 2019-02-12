package devportalpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

WebDriver driver;
	
	By HeaderMessage = By.id("DevHubHeader");
	
	
	public Dashboard(WebDriver driver){
		this.driver = driver;
	}
	
	public String getHeaderMessage() {
		return driver.findElement(HeaderMessage).getText();
	}
	
	
}
