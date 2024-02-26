package com.salesforce.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.pages.base.BasePage;

public class HomePage extends BasePage{

	@FindBy(id="userNav-arrow") WebElement userMenuDropDown;
	@FindBy(xpath="//a[text()='Logout']") WebElement logOut;
	@FindBy(id="Lead_Tab") WebElement leadlink;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickdropDown() {
		clickElement(userMenuDropDown, "UserMenuDropDown");
	}
	
	public void clickLogOut() {
		clickElement(logOut, "logOutLink");
	}
	
	public void clickleadlink() {
		clickElement(leadlink, "leadLinktab");
	}

	

}
