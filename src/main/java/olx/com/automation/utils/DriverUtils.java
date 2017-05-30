package olx.com.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Reporter;

import olx.com.automation.driver.DriverBuilder;

public class DriverUtils {

	public static void saveScreenShot(WebDriver webDriver, String path, String fileNameSufix)
	{
		File f = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            final long timestamp = new Date().getTime();
            Path screenshotPath = Paths.get(path, "target", "screenshot_" + fileNameSufix + "_" + timestamp + ".png");
            System.out.println("copying " + screenshotPath);
            Files.copy(f.toPath(), screenshotPath, StandardCopyOption.REPLACE_EXISTING);
            
            Reporter.log("<img src=\"file://" + screenshotPath + "\" alt=\"\" />");
            
        } catch (IOException e) {
            System.err.println("error during the screenshot copy file operation:" + e.getMessage());
        }
	}
	
	public static void checkBrowserLogs() throws Exception
	{
		WebDriver driver = DriverBuilder.INSTANCE.getDriver();
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
            //System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            // TODO
			if (entry.getLevel().getName().equals("ERROR"))
			{
				Reporter.log(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
				throw new Exception("Error found in the browser log.");
			}
        }
	}
}
