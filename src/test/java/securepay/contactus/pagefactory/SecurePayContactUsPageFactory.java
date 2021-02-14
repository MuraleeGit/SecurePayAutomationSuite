package securepay.contactus.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Global file for locating the elements for ANZ Borrowing calculator page
 * 
 * @author Muralee
 *
 */
public class SecurePayContactUsPageFactory {

	@FindBy(css = "input[title='Search']")
	public WebElement searchBox;


	@FindBy(xpath = "//span[contains(text(),'SecurePay | Trusted Online Payment Gateway Provide')]")
	public WebElement securePayLink;

	@FindBy(xpath = "//span[normalize-space()='Contact us']")
	public WebElement contactUsLink;

	@FindBy(xpath = "//input[contains(@name,'firstName')]")
	public WebElement firstName;

	@FindBy(xpath = "//input[contains(@name,'lastName')]")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[contains(@name,'email')]")
	public WebElement workEmail;

	@FindBy(xpath = "//input[contains(@name,'phone')]")
	public WebElement phoneNumber;

	@FindBy(xpath = "//input[contains(@name,'company')]")
	public WebElement companyName;

	@FindBy(xpath = "//input[contains(@name,'website')]")
	public WebElement websiteURL;

	@FindBy(css = "select")
	public WebElement businessAmount;

	@FindBy(css = "textarea")
	public WebElement yourMessage;
	
	@FindBy(xpath = "//h1[contains(text(),'Contact our Sales Team')]")
	public WebElement contactUsHeader;
	

}
