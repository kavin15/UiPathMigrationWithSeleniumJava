package tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.LoginPage;
import base.base;
import dev.failsafe.internal.util.Assert;

@Listeners(Listerners.TestListener.class)
public class TC01_LoginTest extends base
{
	@Test
	public void verifyUserLogin() throws InterruptedException
	{
		LoginPage login=new LoginPage(driver);
		login.LoginCredentials(getKeyValues("userName"), getKeyValues("password"));
		Assert.isTrue(login.getWelcomeText().contains("Welcome"),"Login failed: Welcome message not displayed");	
	}
}
