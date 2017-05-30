package olx.com.automation.pages.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FacebookLoginPage {

	private static  WebElement element = null;
	private  static String URL = "https://www.facebook.com/login";
	
	
	public static void login(EventFiringWebDriver driver, String userName, String pass) throws Exception
    {
		element = userNameField(driver);
		if (element == null)
		{
			throw new Exception("Element not found.");
		}
		element.sendKeys(userName);
		element = passField(driver);
		if (element == null)
		{
			throw new Exception("Element not found.");
		}
		element.sendKeys(pass);
		element.submit();
    }

    protected static  WebElement userNameField(WebDriver driver)
    {
        return driver.findElement(By.id("email"));
    }

    protected static WebElement  passField(WebDriver driver)
    {
    	return driver.findElement(By.id("pass"));
    }

    protected static WebElement  loginButton(WebDriver driver)
    {
    	return driver.findElement(By.id("loginbutton"));
    }

	public static void init(EventFiringWebDriver driver) 
	{
		driver.get(URL);
		System.out.println("initializing facebook");
		//waitUntilReady(driver);
	}
	
	public static void lala(){
		System.out.println("Lala");
	}

	/*private  void waitUntilReady(WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fbNotificationsJewel")));
	}*/
	
}
