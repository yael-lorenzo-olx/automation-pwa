package olx.com.automation.pages.internal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import olx.com.automation.driver.DriverBuilder;
import olx.com.automation.pages.components.HeaderComponent;

public class BasePage {

	protected static WebElement element = null;
	protected static WebDriver driver = DriverBuilder.INSTANCE.getDriver();
	protected static EventFiringWebDriver eventDriver = DriverBuilder.INSTANCE.getEventDriver();
		
	public static void search(String text) throws Exception 
	{
		// TODO Auto-generated method stub
		HeaderComponent.performSearch(text);
	}
	
	public static void locateProfileMenu()
	{
		HeaderComponent.locateProfileMenu();
	}
	
	public static void goToChat()
	{
		HeaderComponent.goToChat();
	}
}
