package olx.com.automation.testCase;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import olx.com.automation.driver.DriverBuilder;
import olx.com.automation.events.FailTestScreenshotListener;
import olx.com.automation.events.WebEventHandler;
import olx.com.automation.pages.external.FacebookLoginPage;
import olx.com.automation.pages.internal.LandingPage;
import olx.com.automation.pages.internal.ProfilePage;

@Listeners(FailTestScreenshotListener.class)
public class TestCase1 {
	
	private WebDriver driver;
	
	@Test
	public void f() throws Exception
	{	
		try {
			driver.manage().window().maximize();
			FacebookLoginPage.init(eventDriver);
			FacebookLoginPage.login(eventDriver,"hprnpzahde_1495137612@tfbnw.net", "2008295377");
			
			LandingPage.init(driver);
			LandingPage.loginButton(driver).click();
			LandingPage.loginFacebookButton(driver);
			
			ProfilePage.init(driver);
			
			ProfilePage.search("iphone");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException
	{
		driver = DriverBuilder.INSTANCE.getDriver();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		DriverBuilder.INSTANCE.unregisterEventHandler();
		driver.close();
	}
}
