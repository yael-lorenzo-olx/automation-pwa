package olx.com.automation.pages.actions;

import olx.com.automation.driver.DriverBuilder;
import olx.com.automation.pages.external.FacebookLoginPage;
import olx.com.automation.utils.DriverUtils;

public class FacebookAction {

	public static void login(String email, String pass) throws Exception
	{
		FacebookLoginPage.init();
		FacebookLoginPage.login(email, pass);
		DriverUtils.saveScreenShot(DriverBuilder.INSTANCE.getDriver(), System.getProperty("user.dir"), "facebook_page");
	}
	
}
