package devportalpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationSuccessPage {

	WebDriver driver;
	By successText = By.id("successtext");
	
	public AccountCreationSuccessPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getSuccessText() {
		return driver.findElement(successText).getText();
	}
	}
