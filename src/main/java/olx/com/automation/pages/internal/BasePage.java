package olx.com.automation.pages.internal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import olx.com.automation.driver.DriverBuilder;
import olx.com.automation.pages.components.HeaderSearch;

public class BasePage {

	protected static WebElement element = null;
	protected static WebDriver driver = DriverBuilder.INSTANCE.getDriver();
	protected static EventFiringWebDriver eventDriver = DriverBuilder.INSTANCE.getEventDriver();
		
	public static void search(String text) {
		// TODO Auto-generated method stub
		HeaderSearch search = new HeaderSearch();
		search.perform(driver, text);
	}
}
