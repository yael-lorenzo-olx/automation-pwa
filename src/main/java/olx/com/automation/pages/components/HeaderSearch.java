package olx.com.automation.pages.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import olx.com.automation.utils.DriverUtils;

public class HeaderSearch {

	public void perform(WebDriver driver, String textToSearch) throws Exception
	{
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='What are you looking for?']"));
		if (element == null)
		{
			throw new Exception("Search textbox not found.");
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
	
}
