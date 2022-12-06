package com.Nexquare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditStaff extends BasePage {

	public EditStaff(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	By EditStaff = By.xpath("//li[@id='link_editStaff']");

	By Staff = By.xpath("(//Input[@class='select-dropdown dropdown-trigger'])[2]");

	By searchButton = By.xpath("//button[@id='staffSearch']");

	By FullName = By.xpath("//input[@id='firstName']");

	public boolean clickOnStaffEdit() {
		clickandwait(EditStaff);
		return isElementPresent(Staff);

	}

	public void searchStaff(String Staffs) {
		clickandwait(Staff);
		By search = By
				.xpath("//div[@class='col-xl-4 col-md-6 col-12']/div/div//input/following::ul/span/i/following::input");
		SetText(search, Staffs);

		By li = By.xpath("//li//span[normalize-space()='" + Staffs.toUpperCase() + "']");
		clickandwait(li);
	}

	public void clickOnSearchButton() {
		clickandwait(searchButton);
		waitforelementtoBecomeclickable(FullName);

	}

	public String expectedSearchResult() {
		String str = driver.get().findElement(FullName).getText();
		return str;

	}
}
