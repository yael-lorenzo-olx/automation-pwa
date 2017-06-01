package olx.com.automation.pages.internal;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatPage extends BasePage {

	final static Logger LOGGER = Logger.getLogger(ChatPage.class);
	private static final String SEARCH_BOX = "//input[@placeholder='Enter your message']";
	private static final String SEND_MESSAGE = "//input[@placeholder='Enter your message']/following-sibling::span";
	private static final String SENT_MESSAGE = "//text()[contains(., '%s')]/parent::div";
	private static final String WELCOME = "//span[contains(text(), 'Select a chat')]";
	private static final String RECEIVED_MESSAGE = "//text()[contains(., '%s')]/parent::div";

	public static void init()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WELCOME)));
	}

	public static void sendMessage(String message)
	{
		List<WebElement> elements = driver.findElements(By.xpath(SEARCH_BOX));
    	if (elements.isEmpty())
    	{
    		throw new NoSuchElementException("By xpath: " + SEARCH_BOX);
    	}
    	elements.get(0).sendKeys(message);
    	elements = driver.findElements(By.xpath(SEND_MESSAGE));
    	if (elements.isEmpty())
    	{
    		throw new NoSuchElementException("By xpath: " + SEND_MESSAGE);
    	}
    	elements.get(0).click();
	}
	
	public static void validateSentMessage(String message)
	{
		List<WebElement> elements = driver.findElements(By.xpath(String.format(SENT_MESSAGE, message)));
    	if (elements.isEmpty())
    	{
    		throw new NoSuchElementException(String.format(SENT_MESSAGE, message));
    	}
	}

	public static void open(String message) 
	{
		List<WebElement> elements = driver.findElements(By.xpath(String.format(RECEIVED_MESSAGE, message)));
    	if (elements.isEmpty())
    	{
    		throw new NoSuchElementException(String.format(RECEIVED_MESSAGE, message));
    	}
		elements.get(0).click();
	}
}
