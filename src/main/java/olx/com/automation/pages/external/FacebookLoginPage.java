package olx.com.automation.pages.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import olx.com.automation.driver.DriverBuilder;

public class FacebookLoginPage {

	private static  WebElement element = null;
	private  static String URL = "https://www.facebook.com/login";
	protected static WebDriver driver = DriverBuilder.INSTANCE.getDriver();
	protected static EventFiringWebDriver eventDriver = DriverBuilder.INSTANCE.getEventDriver();
	
	
	public static void login(String userName, String pass) throws Exception
    {
		element = userNameField();
		if (element == null)
		{
			throw new Exception("Element not found.");
		}
		element.sendKeys(userName);
		element = passField();
		if (element == null)
		{
			throw new Exception("Element not found.");
		}
		element.sendKeys(pass);
		element.submit();
    }

    protected static  WebElement userNameField()
    {
        return driver.findElement(By.id("email"));
    }

    protected static WebElement  passField()
    {
    	return driver.findElement(By.id("pass"));
    }

    protected static WebElement  loginButton()
    {
    	return driver.findElement(By.id("loginbutton"));
    }

	public static void init() 
	{
		driver.get(URL);
		System.out.println("initializing facebook");
		//waitUntilReady(driver);
	}

	/*private  void waitUntilReady(WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fbNotificationsJewel")));
	}*/
	
}
