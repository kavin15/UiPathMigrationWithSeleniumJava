package Pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	private By welcomeText = By.id("nameofuser");

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void LoginCredentials(String Uname,String password) throws InterruptedException
	{
		LoginButton.click();
		UserName.sendKeys(Uname);
		Thread.sleep(2);

		pwd.sendKeys(password);
		Thread.sleep(2);

		logIn.click();
	}
	public String getWelcomeText() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText))).getText();
	}
}
