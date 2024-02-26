package com.salesforce.stepdef;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.salesforce.pages.home.HomePage;
import com.salesforce.pages.leads.LeadPage;
import com.salesforce.pages.login.LoginPage;
import com.salesforce.utilities.Log4JUtility;
import com.salesforce.utilities.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefination {
	protected static Logger log;
	public WebDriver driver;
	protected static Log4JUtility logObject = Log4JUtility.getInstance();
	LoginPage login;
	HomePage home;
    LeadPage lead;
	public void launchBrowser(String browserName) {
		switch (browserName) {
			case "firefox" :
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();

				break;
			case "chrome" :
				WebDriverManager.chromedriver().setup();
				// System.setProperty("webdriver.chrome.driver",
				// "T:\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();

				break;
		}
		System.out.println(browserName + " browser opened");
	}
	
public WebDriver getDriver() {
	return driver;
}
	public void goToUrl(String url) {
		driver.get(url);
		log.info(url + "is entered");
	}

	public void closeBrowser() {
		driver.close();
		log.info("current browser closed");
	}

	@BeforeAll
	public static void setUpBeforeAllScenarios() {
		log = logObject.getLogger();
	}
	@Before
	public void setUpEachScenario() {

		launchBrowser("firefox");

	}
	@After
	public void tearDown() {
		closeBrowser();
	}
	@AfterStep
	public void after_each_step(Scenario sc) {
		if (sc.isFailed()) {

		}
	}
	@Given("the salesforce url")
	public void the_salesforce_url() {
		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		String url = appProp.getProperty("url");
		goToUrl(url);
	}

	@When("user on {string}")
	public void user_on(String page) {
		if (page.trim().equalsIgnoreCase("LoginPage")) {
			login = new LoginPage(driver);
		} else {
			if (page.trim().equalsIgnoreCase("homepage")) {
				home = new HomePage(driver);
			}
			else {
				if (page.trim().equalsIgnoreCase("leadpage")) {
					lead = new LeadPage(driver);
			}
			}
	}
	}

	@When("i enter the username as {string}")
	public void i_enter_the_username_as(String username) {
		login.enterUserName(username);

	}

	@When("i enter the password as {string}")
	public void i_enter_the_password_as(String password) {
		login.enterPassword(password);
	}

	@When("i clicked on the button")
	public void i_clicked_on_the_button() throws InterruptedException {
		login.clickLoginButton();
		Thread.sleep(3000);
	}

	@Then("i should see the login error message")
	public void i_should_see_the_login_error_message() {
		String ExpectedError = "Please enter your password.";
		WebElement loginError = driver.findElement(By.cssSelector("div#error"));
		String ActualError = loginError.getText();
		assertEquals(ActualError, ExpectedError);
	}
	@Then("i should see the homepage")
	public void i_should_see_the_homepage() {
		String expected = "Home Page ~ Salesforce - Developer Edition";
		String actual = home.getPageTitle();
		Assert.assertEquals(actual, expected);
	}
	@When("i selected remember user name checkbox")
	public void i_selected_remember_user_name_checkbox() {
		login.clickRememberMeButton();
	}

	@When("i clicked the user menu dropdown")
	public void i_clicked_the_user_menu_dropdown() {
		home.ClickdropDown();
	}

	@When("i clicked on the logout button")
	public void i_clicked_on_the_logout_button() throws InterruptedException {
		home.clickLogOut();
		Thread.sleep(3000);
	}

	@Then("i should see the username on the username textbox")
	public void i_should_see_the_username_on_the_username_textbox() {
		String ExpectedUsername = "suganyas@tekarch.com";
		String ActualUsername =login.getUserNameFieldText();
		Assert.assertEquals(ActualUsername, ExpectedUsername);	
	
	}

@When("i click on the forget password")
public void i_click_on_the_forget_password() {
    login.forgetPasswordLink();
}

@Then("i should see the forget password page")
public void i_should_see_the_forget_password_page() {
	String ExpectedMsg = "Forgot Your Password";
	String ActualMsg = login.getForgotPasswordMsg();
	Assert.assertEquals(ActualMsg, ExpectedMsg);
}

@When("i enter the forget password usernamefield as {string}")
public void i_enter_the_forget_password_usernamefield_as(String username) {
    login.enterUserNameInForgotPage(username);
}

@When("i clicked the continue button")
public void i_clicked_the_continue_button() {
    login.clickContinueButton();
}

@Then("i should password reset page with email associated with my username")
public void i_should_password_reset_page_with_email_associated_with_my_username() {
	String ExpectedEmailError = "Check Your Email";
	String ActualEmailError = login.getEmailError();
	Assert.assertEquals(ActualEmailError, ExpectedEmailError);    
}
@When("i entered the wrong username as {string}")
public void i_entered_the_wrong_username_as(String username) {
	login.enterUserName(username); 
}

@When("i entered the wrong password as {string}")
public void i_entered_the_wrong_password_as(String password) {
	login.enterPassword(password);
}

@Then("i should see the error message")
public void i_should_see_the_error_message() {
	String ExpectedLoginError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	String ActualLoginError = login.getInvalidLoginErrorMsg();
	Assert.assertEquals(ActualLoginError, ExpectedLoginError);
    
}

}