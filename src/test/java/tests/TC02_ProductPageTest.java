package tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import base.base;
import dev.failsafe.internal.util.Assert;

@Listeners(Listerners.TestListener.class)
public class TC02_ProductPageTest extends base
{
	@Test
	public void VerifyProductPage() throws InterruptedException 
	{
		LoginPage login=new LoginPage(driver);
		login.LoginCredentials(getKeyValues("userName"), getKeyValues("password"));
		Thread.sleep(3000);	
		HomePage hp=new HomePage(driver);
		hp.laptop();
		Thread.sleep(3000);
		ProductPage pp=new ProductPage(driver);
		pp.firstProduct();
		Assert.isTrue(driver.getCurrentUrl().contains(getKeyValues("productPageURL")),"Product page not opened");
	}
}
