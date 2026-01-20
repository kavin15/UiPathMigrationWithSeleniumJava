package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage 
{
	WebDriver driver;

	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	private WebElement AddToCartButton;
	
	@FindBy(xpath="//a[@class='nav-link' and text()='Cart']")
	private WebElement cartTab;
	
	public cartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void AddCart()
	{
		AddToCartButton.click();
	}
	public void cartButton() 
	{
		cartTab.click();
	}
}
