package olx.com.automation.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderSearch {

	public void perform(WebDriver driver, String textToSearch)
	{
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='What are you looking for?']"));
		if (element != null)
		{
			System.out.println("Found search box!");
		}
	}
	
}
