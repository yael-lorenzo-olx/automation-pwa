package olx.com.automation.pages.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import olx.com.automation.driver.DriverBuilder;
import olx.com.automation.utils.DriverUtils;

public class HeaderComponent {

	private static final String PROFILE_BUTTON = "//span[contains(@class, 'DropDown')]";
	private static final String CHAT_BUTTON = "//a[@href='/chat']/span";
	private static WebDriver driver;
	private static final String SEARCH_BOX = "//input[@placeholder='What are you looking for?']";
	// sell
	// search
	// olx
	// menu
	
	public static void performSearch(String textToSearch) 
	{
		driver = DriverBuilder.INSTANCE.getDriver();
		WebElement element = driver.findElement(By.xpath(SEARCH_BOX));
		if (element == null)
		{
			throw new NoSuchElementException("By xpath: " + SEARCH_BOX);
		}
		if (!element.isDisplayed())
		{
			List<WebElement> elements = driver.findElements(By.xpath("//form/button"));
			for(WebElement we : elements)
			{
				if (we.isDisplayed())
				{
					we.click();
					break;
				}
			}
			//element = driver.findElement(By.xpath("//form/button[@type='reset']"));
			//String clickMagnifier = "arguments[0].style.visibility='visible'; arguments[0].style.display='block';";
			//((JavascriptExecutor)driver).executeScript(clickMagnifier, element);
			DriverUtils.saveScreenShot(driver, System.getProperty("user.dir"), "after reseting the search");
		}
		System.out.println("Found search box!");
		element.sendKeys("iphone");
		element.submit();
	}

	public static void locateProfileMenu()
	{
		driver = DriverBuilder.INSTANCE.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROFILE_BUTTON)));	
		driver.findElement(By.xpath(PROFILE_BUTTON));
		System.out.println("Found profile text!");
	}

	public static void goToChat() 
	{
		driver = DriverBuilder.INSTANCE.getDriver();
		List<WebElement> elements = driver.findElements(By.xpath(CHAT_BUTTON));
    	if (elements.isEmpty())
    	{
    		throw new NoSuchElementException("By xpath: " + CHAT_BUTTON);
    	}
        elements.get(0).click();
		
	}
	
}
