package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;

	@FindBy(id="logout2")
	private WebElement LogoutButton;

	@FindBy(xpath ="//a[contains(text(),'Laptops')]")
	private WebElement clickLaptop;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void LogOut()
	{
		LogoutButton.click();
	}
	public void laptop()
	{
		clickLaptop.click();
	}
}
