package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility 
{
	public static void captureScreenshot(WebDriver driver, String testName) 
	{
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(screenshot, new File("./screenshots/" + testName + ".png"));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public static Properties readingConfig() throws IOException {

		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("data\\config.properties");
		p.load(fis);
		return p;

	}
}
