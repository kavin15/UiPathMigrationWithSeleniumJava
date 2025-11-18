package tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.HomePage;
import base.base;

@Listeners(Listerners.TestListener.class)
public class DemoBlazeTests extends base
{
	@Test
	public void demoBlazeTest() throws InterruptedException
	{
		HomePage h=new HomePage(driver);
		Thread.sleep(3000);
		h.laptop();
	}
}
