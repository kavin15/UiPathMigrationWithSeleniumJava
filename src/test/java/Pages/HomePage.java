package Pages;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	private final WebDriverWait wait;
	
	@FindBy(id="logout2")
	private WebElement LogoutButton;

	@FindBy(xpath ="//a[contains(text(),'Laptops')]")
	private WebElement clickLaptop;
    
	@FindBy(xpath="//a[@class='nav-link' and text()='Home ']")
	private WebElement homeTap;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	public void LogOut()
	{
		wait.until(ExpectedConditions.elementToBeClickable(LogoutButton)).click();
	}
	public void laptop()
	{
		wait.until(ExpectedConditions.elementToBeClickable(clickLaptop)).click();
	}
	public void categorics(WebElement categorics) 
	{
	  categorics.click();
	}
	public void homeButton() 
	{
		homeTap.click();
	}
}
