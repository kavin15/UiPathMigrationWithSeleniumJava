package tests;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.cartPage;
import base.base;
import dev.failsafe.internal.util.Assert;

@Listeners(Listerners.TestListener.class)
public class TC05_endToEnd_ProductCheck extends base
{
	@Test
	public void cartProductChecking() throws InterruptedException 
	{
		LoginPage login=new LoginPage(driver);
		login.LoginCredentials(getKeyValues("userName"), getKeyValues("password"));
		Assert.isTrue(login.getWelcomeText().contains("Welcome"),"Login failed: Welcome message not displayed");
		Thread.sleep(3000);
		int cartCount=0;
		int a=driver.findElements(By.id("itemc")).size();
		for (int i=1;i<=a;i++) {
			Thread.sleep(2000);
			HomePage hp=new HomePage(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='itemc']["+i+"]")).click();
			ProductPage pp=new ProductPage(driver);
			Thread.sleep(2000); 
			pp.firstProduct();
			cartPage cp=new cartPage(driver);
			cp.AddCart();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			assertEquals(alertText, "Product added.");
			cartCount++;
			alert.accept();
			Thread.sleep(2000);
			if(a!=cartCount) 
			{
				hp.homeButton();
			}
			else 
			{
				cp.cartButton();
				assertEquals(cartCount, driver.findElements(By.xpath("//tr[@class='success']")).size());
			}
		}
	}
}
