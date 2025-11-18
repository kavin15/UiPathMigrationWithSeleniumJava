package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;

	@FindBy(id="login2")
	private WebElement LoginButton;

	@FindBy(id="loginusername")
	private WebElement UserName;

	@FindBy(id="loginpassword")
	private WebElement pwd;

	@FindBy(xpath="//button[contains(text(),'Log in')]")
	private WebElement logIn;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void LoginCredentials(String Uname,String password)
	{
		LoginButton.click();
		UserName.sendKeys(Uname);
		pwd.sendKeys(password);
		logIn.click();
	}
}
