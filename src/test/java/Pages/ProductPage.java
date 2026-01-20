package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage 
{
	WebDriver driver;
	private final WebDriverWait wait;
	
	@FindBy(xpath="(//h4[@class='card-title'])[1]")
	private WebElement ClickOnFirstProduct;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	public void firstProduct() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnFirstProduct)).click();
	}
}

