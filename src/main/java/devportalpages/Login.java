/**
 * 
 */
package devportalpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author PA011RA
 * common for login page of all applications
 */
public class Login {

	WebDriver driver;
	
	//By username = By.className("form-control ng-pristine ng-invalid ng-touched");
	By username = By.cssSelector("input.form-control:nth-child(2)");
	By password = By.id("password");
	//By submitButton = By.className("btn btn-primary btn-block btn-lg spacer-top-xs");
	By submitButton = By.cssSelector(".btn");
						
	
	public Login(WebDriver driver){
	
		this.driver = driver;
	}
	
	
	public  void loginToDevPortal(String userid, String passpharase) {
		
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(passpharase);
		driver.findElement(submitButton).click();
	}
	
}
