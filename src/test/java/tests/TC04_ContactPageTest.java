package tests;

import Pages.ContactPage;
import Pages.LoginPage;
import base.base;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listerners.TestListener.class)
public class TC04_ContactPageTest extends base
{

	@Test
	public void testAddContactDetails() throws InterruptedException 
	{
		LoginPage login=new LoginPage(driver);
		login.LoginCredentials(getKeyValues("userName"), getKeyValues("password"));
		ContactPage contactPage=new ContactPage(driver);
		Thread.sleep(3000);
		contactPage.contactButton();

		// Call the method to fill the contact form
		contactPage.addContactDetails(getKeyValues("contactMail"), getKeyValues("contactName"), getKeyValues("message"));

		// Assertions to verify that the contact details were entered correctly
		Assert.assertEquals(contactPage.getRecipientEmail(), getKeyValues("contactMail"), "Email did not match!");
		Assert.assertEquals(contactPage.getRecipientName(), getKeyValues("contactName"), "Name did not match!");
		Assert.assertEquals(contactPage.getMessageText(), getKeyValues("message"), "Message did not match!");
		contactPage.sendButton();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
