package com.salesforce.pages.leads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class LeadPage extends  BasePage{

	@FindBy(id="fcf")WebElement leaddropdown;
	@FindBy(xpath="//*[@id=\"fcf\"]/option[4]")WebElement todayslead;
	//*[@id=\"filter_element\"]/div/span/span[1]/
	@FindBy(xpath="//input[@title='Go!']") WebElement go;
	@FindBy(xpath="//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input") WebElement newbtn;
	@FindBy(id="name_lastlea2") WebElement lastname;
	@FindBy(id="lea3") WebElement companyname;
	@FindBy(xpath="//*[@id=\"topButtonRow\"]/input[1]") WebElement save;
	
public LeadPage(WebDriver driver) {
		super(driver);
	}

public void leaddropdown() {
	clickElement(leaddropdown, "viewdropdown");
}
public void todayslead() {
	clickElement(todayslead, "selecttodayslead");
}
public void go() {
	clickElement(go, "gobutton");
}
public void newbtn() {
	clickElement(newbtn, "newbutton");
}
public void enterlastname(String data) {
	enterText(lastname, data, "lastnamefield");
}	
public void entercompanyname(String data) {
	enterText(companyname, data, "companynamefield");
}	
	public void save() {
		clickElement(save, "savebutton");
	}
	public String getleadsdropdowntext() {
		return getTextFromElement(leaddropdown, "dropdownleads");
	}
}