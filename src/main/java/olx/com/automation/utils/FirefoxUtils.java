package olx.com.automation.utils;

import java.io.File;
import java.util.logging.Level;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxUtils {

	public static DesiredCapabilities setHeader(String name, String value)
	{
		FirefoxProfile profile = new FirefoxProfile();
		 File modifyHeaders = new File(System.getProperty("user.dir") + "/src/main/resources/modify_headers-0.7.1.1-fx.xpi");
		 //profile.setEnableNativeEvents(false); //deprecated
		 
		 profile.addExtension(modifyHeaders); 
		  
		 profile.setPreference("modifyheaders.headers.count", 1);
		 profile.setPreference("modifyheaders.headers.action0", "Add");
		 profile.setPreference("modifyheaders.headers.name0", name);
		 profile.setPreference("modifyheaders.headers.value0", value);
		 profile.setPreference("modifyheaders.headers.enabled0", true);
		 profile.setPreference("modifyheaders.config.active", true);
		 profile.setPreference("modifyheaders.config.alwaysOn", true);
		   
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setBrowserName("firefox");
		 capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
		 capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		   
		 return capabilities;
	}
	
	public static void enableBrowserLog(DesiredCapabilities caps)
	{
		LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
	}
}

