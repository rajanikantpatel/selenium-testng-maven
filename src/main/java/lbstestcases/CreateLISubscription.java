package lbstestcases;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataProviders.ConfigFileReader;
import devportalpages.AccountCreationSuccessPage;
import devportalpages.LBSPlansPage;
import devportalpages.RegistrationPage;
import utils.TestBase;


public class CreateLISubscription extends TestBase{
	
	//WebDriver driver;
	//ConfigFileReader configFileReader= new ConfigFileReader();
	String oAuthToken;

	
/*	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\softwares\\geckodriver.exe");
		FirefoxOptions opts = new FirefoxOptions().setLogLevel(FirefoxDriverLogLevel.TRACE);
		
		driver = new FirefoxDriver(opts);
		driver.manage().window().maximize();
		//driver.manage().timeouts().setScriptTimeout(time, unit)
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

	}*/

	@Test(enabled=true)
	public void CreateLIFreeSubscription() throws InterruptedException {
		
		driver.get(ConfigFileReader.getProperty("LBSPlanPageURL"));
		Thread.sleep(10000);
		
		LBSPlansPage planPage = new LBSPlansPage(driver);
		planPage.clickFreePlan();
		Thread.sleep(10000);
		
		RegistrationPage lbsRegistrationPage = new RegistrationPage(driver);
		
		/*driver.findElement(By.id("firstname-nf")).clear();
		driver.findElement(By.id("firstname-nf")).sendKeys("Rajanikant");
		*/
		lbsRegistrationPage.setFirstName("Rajanikant");
		lbsRegistrationPage.setLastName("Patel");
		//lbsRegistrationPage.setEmail("r3patel"+(new Random().nextInt(10000))+"@gmailcom");
		String emailID = "r3patel"+new Random().nextInt(10000)+"@gmail.com";
		lbsRegistrationPage.setEmail(emailID);
		lbsRegistrationPage.setVerifyEmail(emailID);
		lbsRegistrationPage.setCompany("PB");
		lbsRegistrationPage.setRegion("North, Central and South America");
		lbsRegistrationPage.setLocale("United States");
		lbsRegistrationPage.setAddress("22 Segar Street");
		lbsRegistrationPage.setAddress2("");
		lbsRegistrationPage.setZip("06810");
		lbsRegistrationPage.setCity("Danbury");
		lbsRegistrationPage.setState("CT - Connecticut");
		lbsRegistrationPage.setContact("+1 123 123 1234");
		lbsRegistrationPage.setPromoCode("");
		lbsRegistrationPage.clickCreateAccount();
		Thread.sleep(30000);
		
		AccountCreationSuccessPage lbsAccountCreationSuccess = new  AccountCreationSuccessPage(driver);
		Assert.assertEquals(lbsAccountCreationSuccess.getSuccessText(),"Success!");
		/*
		System.out.println(lbsDashboard.getHeaderMessage());
		Assert.assertEquals(lbsDashboard.getHeaderMessage(),"Locate APIs");*/
	}
	
	
	/*@AfterTest
	public void tearDown() {
		driver.quit();
	}*/
	
}
