package securepay.contactus.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import junit.framework.Assert;
import securepay.contactus.library.GetConfigProperties;
import securepay.contactus.library.ThinkTime;
import securepay.contactus.library.Utility;
import securepay.contactus.pagefactory.SecurePayContactUsPageFactory;

/*
 * Filling contact us details
 * 
 */
public class ContactUsFormFillPage {

	WebDriver driver = null;
	private SecurePayContactUsPageFactory pageFactory;
	private ThinkTime thinkTime;
	private GetConfigProperties getConfigProperties = new GetConfigProperties();
	private Properties prop = null;
	private Utility utility = new Utility();
	private Faker faker = null;

	public ContactUsFormFillPage() {
	}

	public ContactUsFormFillPage(WebDriver driver) {
		this.driver = driver;
		pageFactory = PageFactory.initElements(driver, SecurePayContactUsPageFactory.class);
		thinkTime = new ThinkTime();
		prop = getConfigProperties.getConfigProperty();
		faker = utility.fakerObj();
	}

	/*
	 * This method asserting the actual page header with expected page header
	 */
	public void verifyTheCurrentPageHeader() {
		String header = pageFactory.contactUsHeader.getText();
		Assert.assertEquals(prop.getProperty("contactUsHeader"), header);
	}

	/*
	 * This method fill the contact us form with values generated through faker
	 * class.
	 */
	public void fillContactUsForm() throws InterruptedException {
		thinkTime.waitUntillElementClickable(driver, pageFactory.firstName);
		pageFactory.firstName.sendKeys(faker.name().firstName());
		pageFactory.lastName.sendKeys(faker.name().lastName());
		pageFactory.workEmail.sendKeys(faker.internet().emailAddress());
		pageFactory.phoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
		pageFactory.companyName.sendKeys(faker.company().name());
		pageFactory.websiteURL.sendKeys(faker.company().url());
		pageFactory.yourMessage.sendKeys(faker.name().name());
		Select drpBusinessAmount = new Select(pageFactory.businessAmount);
		drpBusinessAmount.selectByVisibleText(prop.getProperty("businessAmount"));
	}
}
