package com.Nexquare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddStaff extends BasePage {

	public AddStaff(ThreadLocal<WebDriver> driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	By UserName = By.xpath("//*[@id='txtuser']");

	By Passwordfield = By.xpath("(//input[@placeholder='Password'])[1]");

	By LoginButton = By.xpath("//button[@id=\"log-btn\"]");

	By StaffProfileManagement = By.xpath("//div[@id='fl-322-header']");

	By StaffProfileManagement2 = By.xpath("//span[contains(text(),'Staff Profile Management ')]");

	By StaffAdd = By.xpath("( //a[contains(text(),' Staff Add')])[1]");

	By StaffRegNo = By.xpath("//input[@id='staffRegNo']");

	By FullName = By.xpath("//input[@id='staffFullName']");

	By UserType = By.xpath("//input[@class='select-dropdown dropdown-trigger']");

	By Male = By.xpath("//input[@id='radio1']");

	By Female = By.xpath("//input[@id='radio2']");

	By DOB = By.xpath("//input[@id='dob']");

	By ProfessionalEmail = By.xpath("//*[@id='email']");

	By Joininigdate = By.xpath("//input[@id='joinDate']");

	By SalaryDate = By.id("salaryStartDate");

	By SaveButton = By.id("submitButton");

	By StaffHealthDetail = By.xpath("//h2[contains(text(),'Staff Health Details')]");

	public void getURL(String URL) {
		driver.get().get(URL);
		waitforPresenceOFElement(UserName);
	}

	public void SetEmailAndPassword(String userName, String Password) {
		SeTText(UserName, userName);
		SeTText(Passwordfield, Password);

	}

	public void ClickOnLoginButton() {
		clickandwait(LoginButton);
		waitforelementtoBecomeclickable(StaffProfileManagement);

	}

	public boolean clickOnStaffProfileManagement() {
		clickandwait(StaffProfileManagement);
		return isElementPresent(StaffAdd);
	}

	public boolean clickOnStaffAdd() {
		clickandwait(StaffAdd);
		return isElementPresent(FullName);
	}

	public void enterTheFullName(String fullName) {
		SeTText(FullName, fullName);
	}

	public void selectTheUserType(String option) {

		By EmployeeStaff = By.xpath(
				"//*[@class='select-dropdown dropdown-trigger']//following::li//span[contains(text(),'Employee Staff ')]");
		clickandwait(UserType);
		if (option.equalsIgnoreCase("Employee Staff")) {
			clickandwait(EmployeeStaff);
		} else {
			By OtherEmployeeStaff = By.xpath(
					"//*[@class='select-dropdown dropdown-trigger']//following::li//span[contains(text(),'Other Employee Staff')]");
			clickandwait(OtherEmployeeStaff);
		}
	}

	public void SelectGender(String Gender) {

		if (Gender.equalsIgnoreCase("Male")) {
			clickandwait(Male);
		} else {
			clickandwait(Female);
		}
	}

	public boolean selectDateOfBirth(String Dates, int Month, String Years) {
		clickandwait(DOB);
		By Months = By.xpath("//select[@class='ui-datepicker-month browser-default']");
		SelectFromDropDownUsingIndex(Months, Month);
		By Year = By.xpath("//select[@class='ui-datepicker-year browser-default']");
		SelectByUsingVisibleText(Year, Years);
		By Date = By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a[contains(text(),'" + Dates + "')]");
		clickandwait(Date);
		return isElementVisible(DOB);

	}

	public boolean selectDateOfJoining(String Dates, int Month, String Years) {
		clickandwait(Joininigdate);
		By Months = By.xpath("//select[@class='ui-datepicker-month browser-default']");
		SelectFromDropDownUsingIndex(Months, Month);
		By Year = By.xpath("//select[@class='ui-datepicker-year browser-default']");
		SelectByUsingVisibleText(Year, Years);
		By Date = By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a[contains(text(),'" + Dates + "')]");
		clickandwait(Date);
		return isElementVisible(Joininigdate);

	}

	public void enterTheProfessionalEmail(String Email) {
		SetText(ProfessionalEmail, Email);
	}

	public boolean selectDateOfSalary(String Dates, int Month, String Years) {
		clickandwait(SalaryDate);
		By Months = By.xpath("//select[@class='ui-datepicker-month browser-default']");
		SelectFromDropDownUsingIndex(Months, Month);
		By Year = By.xpath("//select[@class='ui-datepicker-year browser-default']");
		SelectByUsingVisibleText(Year, Years);
		By Date = By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a[contains(text(),'" + Dates + "')]");
		clickandwait(Date);
		return isElementVisible(Joininigdate);

	}

	public void clickOnSaveButton() {
		clickandwait(SaveButton);
		waitforelementtoBecomePresent(StaffHealthDetail);

	}

}
