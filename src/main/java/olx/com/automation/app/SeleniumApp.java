package olx.com.automation.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import olx.com.automation.events.WebEventHandler;
import olx.com.automation.pages.external.FacebookLoginPage;
import olx.com.automation.pages.internal.LandingPage;
import olx.com.automation.pages.internal.ProfilePage;
import olx.com.automation.utils.FirefoxUtils;

public class SeleniumApp {

	public static void main(String... args) throws Exception {
			//WebDriver driver = new FirefoxDriver(FirefoxUtils.setHeader("x-origin-panamera", "staging"));			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");
			//System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"false");
			
			///
			
	 		String node = "http://localhost:5001/wd/hub";
	 		//DesiredCapabilities cap = DesiredCapabilities.firefox();
	 
	 		//WebDriver driver = new RemoteWebDriver(new URL(node), FirefoxUtils.setHeader("x-origin-panamera", "staging"));\String URL = "http://www.DemoQA.com";
	 
	 		WebDriver driver = new RemoteWebDriver(new URL(node), FirefoxUtils.setHeader("x-origin-panamera", "staging"));
			
	 		 EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
	 		 WebEventHandler handler = new WebEventHandler();
	 		 eventDriver.register(handler);
			
			try {
				FacebookLoginPage.init(eventDriver);
				FacebookLoginPage.login(eventDriver,"hprnpzahde_1495137612@tfbnw.net", "2008295377");
				
				LandingPage.init(driver);
				LandingPage.loginButton(driver).click();
				LandingPage.loginFacebookButton(driver);
				
				ProfilePage.init(driver);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//driver.get("https://www.olx.com.gh");
			
			/*LandingPage.init(driver);
			LandingPage.loginButton(driver).click();
			LandingPage.loginFacebookButton(driver);
			
			ProfilePage.init(driver);
			Thread.sleep(5000);*/
			
			
			eventDriver.unregister(handler);
			driver.close();
	}
	
}
