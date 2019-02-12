package lbstestcases;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataProviders.ConfigFileReader;
import devportalpages.Dashboard;
import devportalpages.Login;
import io.restassured.response.Response;
import utils.TestBase;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;



public class VerifyLogin extends TestBase{
	
	WebDriver driver;
	//ConfigFileReader configFileReader= new ConfigFileReader();
	String oAuthToken;

	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\softwares\\geckodriver.exe");
		FirefoxOptions opts = new FirefoxOptions().setLogLevel(FirefoxDriverLogLevel.TRACE);
		
		driver = new FirefoxDriver(opts);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

	}

	@Test(enabled=true)
	public void VerifyValidLogin() throws InterruptedException {
		System.out.println("in VerifyValidLogin Method");
		
		driver.get(ConfigFileReader.getProperty("LSBSignInURL"));
		Thread.sleep(10000);
		Login login = new Login(driver);
		login.loginToDevPortal(ConfigFileReader.getProperty("LBSUserName"), ConfigFileReader.getProperty("LBSUserPassword"));
		Thread.sleep(20000);
		
		Dashboard lbsDashboard = new Dashboard(driver);
		System.out.println(lbsDashboard.getHeaderMessage());
		Assert.assertEquals(lbsDashboard.getHeaderMessage(),"Locate APIs");
	}
	
	@Test(enabled=true)
	public void ExecuteOAuthAPI() {
		
		Response response =given().
		headers("Authorization","Basic "+ConfigFileReader.getProperty("BasicToken"),"Content-Type","application/x-www-form-urlencoded").
		body("grant_type=client_credentials").
	when().
		post(ConfigFileReader.getProperty("Host")+ConfigFileReader.getProperty("OAuthTokenPath"));
		
		Assert.assertEquals(response.getStatusCode(), 200);
		oAuthToken=response.jsonPath().get("access_token");
		
	}
	
	@Test(enabled=true,dependsOnMethods= {"ExecuteOAuthAPI"})
	public void ExecuteGeoSearchAPI() {
		
		given().headers("Authorization","Bearer "+oAuthToken,"X-PB-ClientIdentifer","LBSTest-262").
			queryParams("latitude", "40.761819","longitude","-73.997533","searchText","mall").
		when().
			get(ConfigFileReader.getProperty("Host")+ConfigFileReader.getProperty("GeoSearchPath")).
		then().
			assertThat().
				statusCode(200);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
