package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;

	@FindBy(xpath="//a[text()='Contact']")
	private WebElement contactButton;
	
	@FindBy(xpath = "//*[@id='recipient-email']")
	private WebElement recipientEmail;

	@FindBy(xpath = "//*[@id='recipient-name']")
	private WebElement recipientName;

	@FindBy(xpath = "//*[@id='message-text']")
	private WebElement messageText;

	@FindBy(xpath = "//button[contains(text(),'Send message')]")
	private WebElement sendMessageButton;

	@FindBy(xpath = "//button[contains(@class,'close')]")
	private WebElement closeButton;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Method to open the ContactPage
	public void contactButton() {
		contactButton.click(); // Click the "Close" button to Enter into the contactpage
	}

	// Method to add contact details (fills the form and clicks "Send message")
	public void addContactDetails(String email, String name, String message) {
		recipientEmail.sendKeys(email);    // Enter email in the recipient email field
		recipientName.sendKeys(name);      // Enter name in the recipient name field
		messageText.sendKeys(message);     // Enter message in the message textarea
		
	}
    public void sendButton() {
    	sendMessageButton.click();         // Click the "Send message" button
    }
	// Method to close the modal if needed
	public void closeModal() {
		closeButton.click(); // Click the "Close" button to dismiss the modal
	}

	//Method to verify that the form fields are filled correctly
	public String getRecipientEmail() {
		return recipientEmail.getAttribute("value");
	}

	public String getRecipientName() {
		return recipientName.getAttribute("value");
	}

	public String getMessageText() {
		return messageText.getAttribute("value");
	}

}

