package devportalpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LBSPlansPage {

	WebDriver driver;
	
	By freePlan = By.id("choosebtn1");
	By paid5K = By.id("choosebtn2");
	By paid100K = By.id("choosebtn3");
	By enterprise = By.id("choosebtn4");
	
	public LBSPlansPage(WebDriver driver){
		this.driver = driver;
	}
	
	
	public By getFreePlan() {
		return freePlan;
	}

	public void clickFreePlan() {
		driver.findElement(freePlan).click();
	}

	public By getPaid5K() {
		return paid5K;
	}

	public void clickPaid5K() {
		driver.findElement(paid5K).click();
	}

	public By getPaid100K() {
		return paid100K;
	}

	public void clickPaid100K() {
		driver.findElement(paid100K).click();
	}

	public By getEnterprise() {
		return enterprise;
	}

	public void clickEnterprise() {
		driver.findElement(enterprise).click();
	}

	
	
	
}
