package base;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import Pages.HomePage;
import utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class base 
{
	public static WebDriver driver;
	public static Properties properties;
	static {
		try {
			properties=Utility.readingConfig();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static String getKeyValues(String keyValue) 
	{
		return properties.getProperty(keyValue);
	}

	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		driver.manage().window().maximize();
		driver.get(getKeyValues("url"));
	}
	@AfterClass
	public void tearDown() throws InterruptedException 
	{
		HomePage h=new HomePage(driver);
		Thread.sleep(3000);
		h.LogOut();
		driver.quit();
	}
}
