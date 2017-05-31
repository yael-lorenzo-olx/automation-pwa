package olx.com.automation.pages.internal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {

	private  static String URL = "https://www.olx.com.gh";

	/**
	 * Check if the running app is staging.
	 * @param driver
	 * @return
	 */
	public static boolean checkIfNonProduction()
	{
		element = driver.findElement(By.xpath("//div[@id='container']/span[contains(.,'staging')]"));
		if (element != null)
		{
			System.out.println("Found staging text!");
			return true;
		}
		return false;
	}
	
	public static void login() throws InterruptedException
    {
		element = driver.findElement(By.xpath("//span[@class='signINText']"));
		Thread.sleep(3000);
        element.click();
    }

	public static WebElement loginFacebookButton()
    {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='kep-login-facebook metro']")));
    	element = driver.findElement(By.xpath("//button[@class='kep-login-facebook metro']"));
    	element.click();
        return element;
    }
	
	public static void init() throws Exception 
	{
		driver.get(URL);
		//Thread.sleep(3000);
		//waitUntilReady(driver);
		//closePopupOk();
		//checkIfNonProduction();
	}

	public static void closePopupOk() 
	{
		List<WebElement> elements = driver.findElements(By.xpath("//button/span[contains(.,'Ok')]"));
		if (elements.isEmpty())
		{
			return;
		}
		element = elements.get(0);
		element.click();
		
	}
	
	/*public static void waitUntilReady(WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
	}*/
}

