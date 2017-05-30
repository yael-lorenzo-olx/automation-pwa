package olx.com.automation.driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import olx.com.automation.events.WebEventHandler;
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
		 
    DriverBuilder() 
    {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");

        try {
        	driver = new RemoteWebDriver(new URL(node), FirefoxUtils.setHeader("x-origin-panamera", "staging"));
        	
        	eventDriver = new EventFiringWebDriver(driver);
        	handler = new WebEventHandler();
        	eventDriver.register(handler);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public WebDriver getDriver() { return driver; }
    
    public EventFiringWebDriver getEventDriver() { return eventDriver;}

	public void unregisterEventHandler() 
	{
		eventDriver.unregister(handler);	
	}
    
}
