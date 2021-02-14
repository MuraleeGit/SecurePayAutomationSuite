package securepay.contactus.acceptancetests;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * This class is used to configure feature, step definitions and act as an entry
 * point for the automation suite
 * 
 * @author Muralee
 *
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/", glue = "securepay.contactus.steps")
public class SecurePayContactUsTestRunner {

}
