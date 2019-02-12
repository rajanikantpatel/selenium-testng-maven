package devportalpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	WebDriver driver;
	By firstName = By.cssSelector("input#firstname-nf");
	By lastName = By.id("lastname-nf");
	By email = By.id("email-nf");
	By verifyEmail = By.id("verifyemail");
	By company = By.id("company-nf");
	By region = By.id("regionChangeDropdown");
	By locale = By.id("localeChangeDropdown");
	By address = By.id("address1");
	By address2 = By.id("address2");
	By zip = By.id("zip");
	By city = By.id("city");
	By state = By.id("stateselectbox");
	By contact = By.id("contactnumber-nf");
	By promoCode = By.id("promocodeinput");
	By createAccount = By.id("createaccbtn-nf");
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public By getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName1) {
		//driver.findElement(firstName).clear();
		//driver.switchTo().activeElement().findElement(firstName).sendKeys(firstName1);
		driver.findElement(firstName).sendKeys(firstName1);
	}
	public By getLastName() {
		return lastName;
	}
	public void setLastName(String lastName1) {
		driver.findElement(lastName).sendKeys(lastName1);
	}
	public By getEmail() {
		return email;
	}
	public void setEmail(String email1) {
		driver.findElement(email).sendKeys(email1);
	}
	public By getVerifyEmail() {
		return verifyEmail;
	}
	public void setVerifyEmail(String verifyEmail1) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(verifyEmail).sendKeys(verifyEmail1);
	}
	public By getCompany() {
		return company;
	}
	public void setCompany(String company1) {
		driver.findElement(company).sendKeys(company1);
	}
	public By getRegion() {
		return region;
	}
	public void setRegion(String region1) {
		
		Select regionDropdown = new Select(driver.findElement(region));
		regionDropdown.selectByVisibleText(region1);
		
	}
	public By getLocale() {
		return locale;
	}
	public void setLocale(String locale1) {
		
		Select localeDropdown = new Select(driver.findElement(locale));
		localeDropdown.selectByVisibleText(locale1);
	}
	public By getAddress() {
		return address;
	}
	public void setAddress(String address1) {
		driver.findElement(address).sendKeys(address1);
	}
	public By getAddress2() {
		return address2;
	}
	public void setAddress2(String address12) {
		driver.findElement(address2).sendKeys(address12);
	}
	public By getZip() {
		return zip;
	}
	public void setZip(String zip1) {
		
		driver.findElement(zip).sendKeys(zip1);
	}
	public By getCity() {
		return city;
	}
	public void setCity(String city1) {
		driver.findElement(city).sendKeys(city1);;
	}
	public By getState() {
		return state;
	}
	public void setState(String state1) {
		Select stateDropdown = new Select(driver.findElement(state));
		stateDropdown.selectByVisibleText(state1);
	}
	public By getContact() {
		return contact;
	}
	public void setContact(String contact1) {
		
		driver.findElement(contact).sendKeys(contact1);
	}
	public By getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode1) {
		driver.findElement(promoCode).sendKeys(promoCode1);
	}
	public By getCreateAccount() {
		return createAccount;
	}
	public void clickCreateAccount() {
		if(!driver.findElement(createAccount).isEnabled()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
		driver.findElement(createAccount).click();
	}
	
}
