package securepay.contactus.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import securepay.contactus.library.ThinkTime;
import securepay.contactus.pagefactory.SecurePayContactUsPageFactory;

public class GoogleSearchPage {

	WebDriver driver = null;
	private SecurePayContactUsPageFactory pageFactory;
	private ThinkTime thinkTime;

	/*
	 * Constructor declaration
	 * 
	 * 
	 */
	public GoogleSearchPage() {

	}

	/*
	 * This method initializes the Webdriver
	 * 
	 * 
	 * 
	 */
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		pageFactory = PageFactory.initElements(driver, SecurePayContactUsPageFactory.class);
		thinkTime = new ThinkTime();
	}

	/*
	 * This method search for SecurePay in google
	 * 
	 * 
	 * 
	 * 
	 */
	public void searchForSecurePay(String searchValue) {
		thinkTime.waitUntillElementClickable(driver, pageFactory.searchBox);
		pageFactory.searchBox.sendKeys(searchValue);
		pageFactory.searchBox.sendKeys(Keys.ENTER);
	}
	/*
	 * This Method clicks on the SecurePay link from google search results
	 */

	public void clickOnSecurePayLink() {
		thinkTime.waitUntillElementClickable(driver, pageFactory.securePayLink);
		pageFactory.securePayLink.click();
	}

}
