package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.Message;
import factory.DriverFactory;
import utilities.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	ElementUtils elementUtils = new ElementUtils(DriverFactory.getDriver());	

	private By txtEmail = By.name("username");
	private By txtPassword = By.name("password");
	private By btnLogin = By.xpath("(//button//*[text()='Login'])[2]");
	private By btnCreateAccount = By.xpath("//button//*[text()='Create an account']");
	private By lbErrorMessage = By.xpath("//div[@class='MuiAlert-message']");
	
	public void inputEmail(String email) {	
		elementUtils.doSendKeys(txtEmail, email);
	}
	
	public void inputPassword(String password) {
		elementUtils.doSendKeys(txtPassword, password);
	}
	
	public void clickLogin() {
		elementUtils.doClick(btnLogin);
	}
	
	public HomePage doLogin(String email, String password) {
		elementUtils.doSendKeys(txtEmail, email);
		elementUtils.doSendKeys(txtPassword, password);
		elementUtils.doClick(btnLogin);
		return new HomePage(driver);
	}
	public void clickCreateAccount() {
		elementUtils.doClick(btnCreateAccount);
	}
	
	public String getErrorMessage() {
		return elementUtils.getText(lbErrorMessage);
	}
	
	public Boolean isLoginSuccess() {
		return elementUtils.isElementBehind(btnLogin);
	}
	
	public Boolean isLoginFailed() {
		Boolean isTrue = false;
		String errMessage = getErrorMessage();
		isTrue = elementUtils.isElementDisplayed(btnLogin) 
				&& errMessage.contains(Message.LOGIN_EMAIL_OR_PASSWORD_IS_INCORRECT);
		return isTrue;
	}
	
}
