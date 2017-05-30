package olx.com.automation.pages.internal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	private static WebElement element = null;
	private  static String URL = "https://www.olx.com.gh";

	/**
	 * Check if the running app is staging.
	 * @param driver
	 * @return
	 */
	public static boolean checkIfNonProduction(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='container']/span[contains(.,'staging')]"));
		if (element != null)
		{
			System.out.println("Found staging text!");
			return true;
		}
		return false;
	}
	
	public static WebElement loginButton(WebDriver driver) throws InterruptedException
    {
		element = driver.findElement(By.xpath("//span[@class='signINText']"));
		//Thread.sleep(5000);
        return element;
    }

	public static WebElement loginFacebookButton(WebDriver driver)
    {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='kep-login-facebook metro']")));
    	element = driver.findElement(By.xpath("//button[@class='kep-login-facebook metro']"));
    	element.click();
        return element;
    }
	
	public static void init(WebDriver driver) throws Exception 
	{
		driver.get(URL);
		//Thread.sleep(5000);
		//waitUntilReady(driver);
		closePopupOk(driver);
		checkIfNonProduction(driver);
	}

	private static void closePopupOk(WebDriver driver) 
	{
		List<WebElement> elements = driver.findElements(By.xpath("//button/span[contains(.,'Ok')]"));
		if (elements.isEmpty())
		{
			return;
		}
		element = elements.get(0);
		element.click();
		
	}
	
	public static void waitUntilReady(WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
	}
}

