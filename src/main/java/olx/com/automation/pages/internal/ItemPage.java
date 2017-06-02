package olx.com.automation.pages.internal;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ItemPage extends BasePage {

	final static Logger LOGGER = Logger.getLogger(LandingPage.class);
	private final static String ITEM_CHAT = "//div[contains(text(),'Chat')]/parent::a";

	public static void init(String url) throws Exception 
	{
		initializeDrivers();
		driver.get(url);
	}

	public static void clickOnChat()
	{
		List<WebElement> elements = driver.findElements(By.xpath(ITEM_CHAT));
    	if (elements.isEmpty())
    	{
    		throw new NoSuchElementException("By xpath: " + ITEM_CHAT);
    	}
    	for(WebElement e : elements)
    	{
    		if (e.isDisplayed())
    		{
    			e.click();
    			break;
    		}
    	}
        
	}
}
