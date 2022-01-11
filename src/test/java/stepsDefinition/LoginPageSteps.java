package stepsDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import utilities.HttpRequest;
import pageObjects.HomePage;
import common.CommonConst;

public class LoginPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	
	
	@Given("User is on Login page")
	public void user_is_on_login_page() {
		homePage.clickLoginStart();
		homePage.clickLogin();
//		String token = HttpRequest.getToken();
//		System.out.println("====token: " + token);
	}

	@When("User input default email and password")
	public void user_input_default_email_and_password() {
		loginPage.inputEmail(CommonConst.DEFAULT_USERNAME);
		loginPage.inputPassword(CommonConst.DEFAULT_PASSWORD);
	}

	@When("User input email {string} and password {string}")
	public void user_input_email_and_password(String email, String password) {
		loginPage.inputEmail(email);
		loginPage.inputPassword(password);
	}
	
	@When("User click Login button")
	public void user_click_login_button() {
		loginPage.clickLogin();
	}	
	
	@Then("Verify that log in status is {string}")
	public void verify_that_log_in_status_is(String loginStatus) {
		if (loginStatus.toLowerCase().equals("success")) {
			Assert.assertFalse(loginPage.isLoginSuccess());
			
		} else {
			Assert.assertTrue(loginPage.isLoginFailed());
		}
	}
	
	@Then("User login successfully")
	public void user_login_successfully() throws InterruptedException {
		Thread.sleep(1000);		
		Boolean isDisplayed = DriverFactory.getDriver().findElements(By.xpath("(//button//*[text()='Login'])[2]")).size()>0;
		Assert.assertFalse(isDisplayed);
	}

}
