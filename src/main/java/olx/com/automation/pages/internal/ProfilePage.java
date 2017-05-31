package olx.com.automation.pages.internal;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
	
	public static void init()
    {
		waitUntilReady();
		element = driver.findElement(By.xpath("//span[contains(@class, 'DropDown')]"));
		if (element != null)
		{
			System.out.println("Found profile text!");
		}
    }
	
	private static void waitUntilReady() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'DropDown')]")));
	}
}
