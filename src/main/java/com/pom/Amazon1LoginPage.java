package com.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseClass.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Amazon1LoginPage extends BaseClass {

	public WebDriver LoginpagDriverdriver;

	@FindBy(id = "nav-link-accountList")
	private WebElement signinbtn;

	@FindBy(id = "ap_email_login")
	private WebElement sendEmail;

	@FindBy(xpath = "//div[@class='a-alert-content'][1]")
	private WebElement verifyEmptyEmail;

	@FindBy(xpath = "//div[contains(text(),'Invalid email address')]")
	private WebElement verifyIncorrectEmail;

	@FindBy(xpath = "//input[@class='a-button-input']")
	private WebElement clickEmailContinue;

	@FindBy(id = "ap_password")
	private WebElement sendPass;

	@FindBy(xpath = "//div[contains(text(),'Enter your password')]")
	private WebElement verifyEmptyPass;

	@FindBy(xpath = " //*[contains(text(),'Your password is incorrec')]")
	private WebElement verifyIncorrectPass;

	@FindBy(id = "signInSubmit")
	private WebElement clickpassSigninBtn;

	public Amazon1LoginPage(WebDriver driver) {

		this.LoginpagDriverdriver = driver;
		PageFactory.initElements(LoginpagDriverdriver, this);

	}

	public boolean validLogin(ExtentTest extendstest) {

		try {
			getUrl("https://www.amazon.in/");
			implicityWait(15);
			click(signinbtn);
			sendkeys(LoginpagDriverdriver, sendEmail, "vishnupriyanr16@gmail.com");
			click(clickEmailContinue);
			sendkeys(LoginpagDriverdriver, sendPass, "vishnu88");
			click(clickpassSigninBtn);
			String title = LoginpagDriverdriver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title,
					"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
			extendstest.log(Status.PASS, "login success");
		} catch (Exception e) {
			extendstest.log(Status.FAIL, "login failed" + e.getMessage());
			return false;
		}
		return true;
	}

	public void validEmailInvalidPass() {
		getUrl("https://www.amazon.in/");
		implicityWait(15);
		click(signinbtn);
		sendkeys(LoginpagDriverdriver, sendEmail, "vishnupriyanr16@gmail.com");
		click(clickEmailContinue);
		sendkeys(LoginpagDriverdriver, sendPass, "vishnu");
		click(clickpassSigninBtn);
		String incorrPass = verifyIncorrectPass.getText();
		System.out.println(incorrPass);
		Assert.assertEquals(incorrPass, "Your password is incorrect");
	}
	
	public void validEmailEmptyPass() {
		getUrl("https://www.amazon.in/");
		implicityWait(15);
		click(signinbtn);
		sendkeys(LoginpagDriverdriver, sendEmail, "vishnupriyanr16@gmail.com");
		click(clickEmailContinue);
		sendkeys(LoginpagDriverdriver, sendPass, "vishnu");
		click(clickpassSigninBtn);
		String emptyemail = verifyEmptyPass.getText();
		System.out.println(emptyemail);
		Assert.assertEquals(emptyemail,"Enter your password");

	}
	
	public void emptyEmail() {
		getUrl("https://www.amazon.in/");
		implicityWait(15);
		click(signinbtn);
		sendkeys(LoginpagDriverdriver, sendEmail, "");
		click(clickEmailContinue);
		String emptypass = verifyEmptyEmail.getText();
		System.out.println(emptypass);
		Assert.assertEquals(emptypass,"Enter your mobile number or email");
	}
	

//	validEmailIncorrect

}
