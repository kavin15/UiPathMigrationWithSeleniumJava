package base;
import java.time.Duration;
import Pages.LoginPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
public class base 
{
	public static WebDriver driver;

	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
	}
	
	@BeforeMethod
	public void Login()
	{
		LoginPage l=new LoginPage(driver);
		l.LoginCredentials("kavinSakthivel", "123456789");
	}
	@AfterMethod
	public void Logout() throws InterruptedException
	{
		HomePage h=new HomePage(driver);
		Thread.sleep(3000);
		h.LogOut();
	}

	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
