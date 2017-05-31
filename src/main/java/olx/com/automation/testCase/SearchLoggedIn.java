package olx.com.automation.testCase;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
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
public class SearchLoggedIn {
	
	private WebDriver driver;
	final static Logger LOGGER = Logger.getLogger(LandingPage.class);
	
	@Test
	public void TestSearchLoggedIn() throws Exception
	{	
		try {	
			
			FacebookLoginPage.init();
			FacebookLoginPage.login("hprnpzahde_1495137612@tfbnw.net", "2008295377");
			DriverUtils.saveScreenShot(driver, System.getProperty("user.dir"), "facebook_page");
			
			LandingPage.init();
			LandingPage.checkIfNonProduction();
			LandingPage.closePopupOk();
			
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
		LOGGER.info("Start test: " + this.getClass().getName());
		Dimension scrDim = driver.manage().window().getSize();
		LOGGER.info(String.format("Screen size is: %s width x %s height.", scrDim.width, scrDim.height));
	}
	
	@AfterMethod
	public void afterMethod()
	{
		DriverBuilder.INSTANCE.unregisterEventHandler();
		driver.close();
		LOGGER.info("End test: " + this.getClass().getName());
	}
}
