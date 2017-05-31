package olx.com.automation.testCase;

import java.net.MalformedURLException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import olx.com.automation.driver.DriverBuilder;
import olx.com.automation.events.FailTestScreenshotListener;
import olx.com.automation.pages.external.FacebookLoginPage;
import olx.com.automation.pages.internal.LandingPage;
import olx.com.automation.pages.internal.ProfilePage;
import olx.com.automation.utils.DriverUtils;

@Listeners(FailTestScreenshotListener.class)
public class TestCase1 {
	
	private WebDriver driver;
	
	@Test
	public void f() throws Exception
	{	
		try {
			Dimension scrDim = driver.manage().window().getSize();
			System.out.println("Screen height: " + scrDim.height);
			System.out.println("Screen width: " + scrDim.width);
			
			//setCapability("screenResolution", "1024x768");
			
			FacebookLoginPage.init();
			FacebookLoginPage.login("hprnpzahde_1495137612@tfbnw.net", "2008295377");
			DriverUtils.saveScreenShot(driver, System.getProperty("user.dir"), "facebook_page");
			
			LandingPage.init();
			LandingPage.checkIfNonProduction();
			LandingPage.closePopupOk();
		
			scrDim = driver.manage().window().getSize();
			System.out.println("Screen height: " + scrDim.height);
			System.out.println("Screen width: " + scrDim.width);
			
			DriverUtils.saveScreenShot(driver, System.getProperty("user.dir"), "init_landing_page");
			LandingPage.login();
			LandingPage.loginFacebookButton();
			
			ProfilePage.init();
			
			ProfilePage.search("iphone");
			DriverUtils.saveScreenShot(driver, System.getProperty("user.dir"), "iphone search");
			
			DriverUtils.checkBrowserLogs();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException
	{
		driver = DriverBuilder.INSTANCE.getDriver(new Dimension(1073, 800));
		//driver = DriverBuilder.INSTANCE.getDriver();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		DriverBuilder.INSTANCE.unregisterEventHandler();
		driver.close();
	}
}
