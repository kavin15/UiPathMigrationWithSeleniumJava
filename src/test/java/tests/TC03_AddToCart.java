package tests;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.cartPage;
import base.base;

@Listeners(Listerners.TestListener.class)
public class TC03_AddToCart extends base{

	@Test
	public void addToCartVerify() throws InterruptedException 
	{
		LoginPage login=new LoginPage(driver);
		login.LoginCredentials(getKeyValues("userName"), getKeyValues("password"));
		Thread.sleep(3000);
		HomePage hp=new HomePage(driver);
		hp.laptop();
		Thread.sleep(3000);
		ProductPage pp=new ProductPage(driver);
		pp.firstProduct();
		Thread.sleep(3000);
		cartPage cp=new cartPage(driver);
		cp.AddCart();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		assertEquals(alertText, "Product added.");
		alert.accept();
	}

}
