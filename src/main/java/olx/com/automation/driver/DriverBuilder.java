package olx.com.automation.driver;

import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import olx.com.automation.events.WebEventHandler;
import olx.com.automation.testCase.ChatConversation;
import olx.com.automation.utils.FirefoxUtils;

// DriverBuilder.INSTANCE is a singleton pattern in Java with enum
// enum fields are compile time constants, but they are instances 
//of their enum type. And, they're constructed when the enum 
// type is referenced for the first time.
public enum DriverBuilder {
	INSTANCE;
	
	private WebDriver driver;
	private String node = "http://localhost:5001/wd/hub";
	private EventFiringWebDriver eventDriver;
	private WebEventHandler handler;
	private Dimension dimension;
	final static Logger LOGGER = Logger.getLogger(ChatConversation.class);
		 
    DriverBuilder() 
    {
    	createDriver();
    }
    
    public WebDriver getDriver() 
    { 
    	if (isDriverClosed())
    	{
    		createDriver();
		}
    	if (dimension != null)
    	{
    		driver.manage().window().setSize(dimension);
    	}
    	return driver; 
    }
    
    public EventFiringWebDriver getEventDriver() { return eventDriver;}

	public void unregisterEventHandler() 
	{
		eventDriver.unregister(handler);	
	}

	public WebDriver getDriver(Dimension dimension) 
	{
		if (isDriverClosed())
    	{
    		createDriver();
		}
		this.dimension = dimension;
		driver.manage().window().setSize(dimension);
		return driver;
	}
	
	private void createDriver()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");

        try {
        	DesiredCapabilities caps = FirefoxUtils.setHeader("x-origin-panamera", "staging");
        	FirefoxUtils.enableBrowserLog(caps);
        	driver = new RemoteWebDriver(new URL(node), caps);
        	
        	eventDriver = new EventFiringWebDriver(driver);
        	handler = new WebEventHandler();
        	eventDriver.register(handler);
        	//LOGGER.info("New driver instantiated");
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
	}
	
	public boolean isDriverClosed()
	{
		return ((RemoteWebDriver) driver).getSessionId() == null;
	}
    
}
