package securepay.contactus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import securepay.contactus.library.ThinkTime;
import securepay.contactus.pagefactory.SecurePayContactUsPageFactory;

/*
 * Click on contact us link and navigating to Contact Us form filling page
 * 
 */
public class SecurePayHomePage {

	WebDriver driver = null;
	private SecurePayContactUsPageFactory pageFactory;
	private ThinkTime thinkTime;

	public SecurePayHomePage() {

	}

	public SecurePayHomePage(WebDriver driver) {
		this.driver = driver;
		pageFactory = PageFactory.initElements(driver, SecurePayContactUsPageFactory.class);
		thinkTime = new ThinkTime();
	}
	/*
	 * This method click on the contact us page
	 */

	public void clickContactUsLink() {
		thinkTime.waitUntillElementClickable(driver, pageFactory.contactUsLink);
		pageFactory.contactUsLink.click();

	}
}
