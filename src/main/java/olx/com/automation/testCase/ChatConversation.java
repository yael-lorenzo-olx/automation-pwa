package olx.com.automation.testCase;

import java.net.MalformedURLException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import olx.com.automation.driver.DriverBuilder;
import olx.com.automation.events.FailTestScreenshotListener;
import olx.com.automation.pages.actions.FacebookAction;
import olx.com.automation.pages.actions.LandingPageAction;
import olx.com.automation.pages.internal.ChatPage;
import olx.com.automation.pages.internal.ItemPage;
import olx.com.automation.pages.internal.LandingPage;
import olx.com.automation.pages.internal.ProfilePage;
import olx.com.automation.utils.DriverUtils;

@Listeners(FailTestScreenshotListener.class)
public class ChatConversation {
	
	private WebDriver driver;
	final static Logger LOGGER = Logger.getLogger(LandingPage.class);
	
	@Test
	public void TestChat() throws Exception
	{	
		try {	
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			FacebookAction.login("ugwdhkzbyy_1496174948@tfbnw.net", "2016388329");
			
			LandingPageAction.loginFacebook();
			
			ProfilePage.init();
			
			ItemPage.init("https://www.olx.com.gh/item/background-image-iid-1050002051");
			DriverUtils.saveScreenShot(driver, System.getProperty("user.dir"), "item_detail");
			ItemPage.clickOnChat();
			DriverUtils.saveScreenShot(driver, System.getProperty("user.dir"), "click_on_chat");
			
			//ChatPage.init();
			String uniqueID = UUID.randomUUID().toString();
			ChatPage.sendMessage(uniqueID);
			ChatPage.validateSentMessage(uniqueID);
			DriverUtils.saveScreenShot(driver, System.getProperty("user.dir"), "chat_sent");
			
			driver.close();
			
			///////////////////////////  >>>> user number 2
			
			FacebookAction.login("hprnpzahde_1495137612@tfbnw.net", "2008295377");
			LandingPageAction.loginFacebook();
			ProfilePage.init();
			ProfilePage.goToChat();
			DriverUtils.saveScreenShot(driver, System.getProperty("user.dir"), "click_on_chat_2");
			ChatPage.init();
			ChatPage.open(uniqueID);
			DriverUtils.saveScreenShot(driver, System.getProperty("user.dir"), "click_on_chat_2_opened");
			
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
