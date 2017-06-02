package olx.com.automation.pages.external;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import olx.com.automation.driver.DriverBuilder;

public class FacebookLoginPage {

	private static  WebElement element = null;
	private  static String URL = "https://www.facebook.com/login";
	protected static WebDriver driver;
	protected static EventFiringWebDriver eventDriver;
	public static final String EMAIL = "email";
	public static final String PASS = "pass";
	
	
	public static void login(String userName, String pass) throws Exception
    {
		element = userNameField();
		element.sendKeys(userName);
		element = passField();
		element.sendKeys(pass);
		element.submit();
    }

    protected static  WebElement userNameField()
    {
    	List<WebElement> elements = driver.findElements(By.id(EMAIL));
    	if (elements.isEmpty())
    	{
    		throw new NoSuchElementException("By id: " + EMAIL);
    	}
        return elements.get(0);
    }

    protected static WebElement  passField()
    {
    	return driver.findElement(By.id(PASS));
    }

    protected static WebElement  loginButton()
    {
    	return driver.findElement(By.id("loginbutton"));
    }

	public static void init() 
	{
		driver = DriverBuilder.INSTANCE.getDriver();
		eventDriver = DriverBuilder.INSTANCE.getEventDriver();
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
