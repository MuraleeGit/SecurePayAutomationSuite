package securepay.contactus.steps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import securepay.contactus.library.GetConfigProperties;
import securepay.contactus.library.SetDrivers;
import securepay.contactus.pagefactory.SecurePayContactUsPageFactory;
import securepay.contactus.pages.ContactUsFormFillPage;
import securepay.contactus.pages.GoogleSearchPage;
import securepay.contactus.pages.SecurePayHomePage;

public class StepDefinition {

	public static Logger log = LogManager.getLogger(StepDefinition.class.getName());

	/*
	 * Constructor declaration
	 * 
	 */
	public StepDefinition() {

	}

	WebDriver driver;
	SecurePayContactUsPageFactory securePayContactUsPageFactory;

	@Steps
	GoogleSearchPage googleSearchPage;
	SecurePayHomePage securePayHomePage;
	ContactUsFormFillPage contactUsFormFillPage;
	GetConfigProperties getProps = new GetConfigProperties();
	SetDrivers setDrivers = new SetDrivers();
	Properties prop = new Properties();

	/*
	 * This @before method initializes the webdriver 
	 * 
	 * 
	 */
	@Before
	public void init() {
		prop = getProps.getConfigProperty();
		String runEnv = System.getProperty("runEnv");
		driver = setDrivers.setDrivers(runEnv);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("SecurePay init");
	}

	@Given("^I am on google search page$")
	public void I_am_on_google_search_page() {
		String url = prop.getProperty("url");
		driver.get(url);
		log.info("I am in google search page");
	}

	@When("^I search in google for \"([^\"]*)\"$")
	public void i_search_for_SecurePay_in_google(String searchValue) throws InterruptedException {
		googleSearchPage = new GoogleSearchPage(driver);
		googleSearchPage.searchForSecurePay(searchValue);
		log.info("I searched for Securepay in google");
	}

	@And("^I click on SecurePay online payments website$")
	public void i_click_on_SecurePay_online_payments_website() throws InterruptedException {
		googleSearchPage.clickOnSecurePayLink();
		log.info("I click on the securepay link");
	}

	@And("^I click on contact us link from SecurePay page$")
	public void i_click_on_contact_us_link_from_SecurePay_page() throws InterruptedException {
		securePayHomePage = new SecurePayHomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10000)");
		securePayHomePage.clickContactUsLink();
		log.info("After the securepay page is opened, I click on Contact Us link");
	}

	@And("^I verifies that contact us page is loaded$")
	public void i_verifies_that_contact_us_page_is_loaded() {
		contactUsFormFillPage = new ContactUsFormFillPage(driver);
		contactUsFormFillPage.verifyTheCurrentPageHeader();
		log.info("I verify that the page opened is SecurePay Contact us page");
	}

	@Then("^I fill the contact us form$")
	public void i_fill_the_contact_us_form() throws InterruptedException {
		contactUsFormFillPage.fillContactUsForm();
		log.info("I fill the contact us page");
	}

	@After
	public void quitBrowsers() {
		driver.quit();
		log.info("Quit Browser");
	}

}
