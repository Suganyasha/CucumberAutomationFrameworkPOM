package com.salesforce.stepdef;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
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

public class LeadsStepDefination {
	private LoginStepDefination loginstepdef ;
	WebDriver driver;
	public LeadsStepDefination(LoginStepDefination loginstepdef) {
		this.loginstepdef =loginstepdef;
		driver =loginstepdef.getDriver();
	}
	@When("i clicked the leads tab")
	public void i_clicked_the_leads_tab() throws InterruptedException {
	    loginstepdef.home.clickleadlink();
	    Thread.sleep(3000);
	}

	@Then("i should see the leads page")
	public void i_should_see_the_leads_page() {
		String Expected ="Leads: Home ~ Salesforce - Developer Edition";
		String Actual = loginstepdef.home.getPageTitle();
		Assert.assertEquals(Actual,Expected);
}
	@When("i clicked the dropdownlist")
	public void i_clicked_the_dropdownlist() {
	 loginstepdef.lead.leaddropdown();  
	}

	@Then("i should see the dropdownlist")
	public void i_should_see_the_dropdownlist() {
		loginstepdef.lead.getleadsdropdowntext();
	}
}