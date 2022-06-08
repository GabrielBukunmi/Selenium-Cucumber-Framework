package StepDefination;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.junit.Cucumber;
import pageObject.Landingpage;
import pageObject.Loginpage;
import pageObject.Portalpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import resources.Base;

public class StepDefination extends Base {

	@Given("initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();

	}

	@Given("navigate to {string} site")
	public void navigate_to_site(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.get(string);

	}

	@Given("click on Login link in homepage to land on secure sign in page")
	public void click_on_login_link_in_homepage_to_land_on_secure_sign_in_page() {
		// Write code here that turns the phrase above into concrete actions
		Landingpage ld = new Landingpage(driver);
		Loginpage lg = ld.signin();

	}

	@When("^user enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		Loginpage lg = new Loginpage(driver);

		lg.username().sendKeys(username);
		lg.password().sendKeys(password);
		lg.submit().click();

	}

	@Then("verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() {
		// Write code here that turns the phrase above into concrete actions
		Portalpage portal = new Portalpage(driver);
		Assert.assertTrue(portal.store().isDisplayed());
	}

}
