package olx.com.automation.pages.actions;

import olx.com.automation.driver.DriverBuilder;
import olx.com.automation.pages.internal.LandingPage;
import olx.com.automation.utils.DriverUtils;

public class LandingPageAction {

	public static void loginFacebook() throws Exception 
	{
		LandingPage.init();
		LandingPage.checkIfNonProduction();
		LandingPage.closePopupOk();
		
		DriverUtils.saveScreenShot(DriverBuilder.INSTANCE.getDriver(), System.getProperty("user.dir"), "init_landing_page");
		LandingPage.login();
		LandingPage.loginFacebookButton();
	}

	
}
