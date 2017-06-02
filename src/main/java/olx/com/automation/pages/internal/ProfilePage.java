package olx.com.automation.pages.internal;

import org.apache.log4j.Logger;

public class ProfilePage extends BasePage {
	
	final static Logger LOGGER = Logger.getLogger(ProfilePage.class);

	public static void init()
    {
		initializeDrivers();
		locateProfileMenu();
    }
	
}
