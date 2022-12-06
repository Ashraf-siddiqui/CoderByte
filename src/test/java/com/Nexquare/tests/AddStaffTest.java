package com.Nexquare.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Extras.ReportGenerator;
import Extras.RetryUtil;

@Listeners(Extras.Listeneres.class)

public class AddStaffTest extends BaseTest {

	@Test
	public void personalDetails() throws Exception {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddStaff().getURL(prop.URL());

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddStaff().SetEmailAndPassword(prop.UserName(), prop.PWD());

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getAddStaff().ClickOnLoginButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Staff Profile Management . ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddStaff().clickOnStaffProfileManagement(),
					"Staff Profile Management Is Not Clicked");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Staff Add. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddStaff().clickOnStaffAdd(), "Staff Add Is Not Clicked");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Enter The Full Name.");
		pages.getAddStaff().enterTheFullName("Automation Test");

		ReportGenerator.getExtentReport().log(Status.INFO, "Select The User Type.");
		pages.getAddStaff().selectTheUserType("Employee Staff");

		ReportGenerator.getExtentReport().log(Status.INFO, "Select The Gender.");
		pages.getAddStaff().SelectGender("male");

		ReportGenerator.getExtentReport().log(Status.INFO, "Enter The Date Of Birth. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddStaff().selectDateOfBirth("25", 11, "1995"),
					"Enter The Date Of Birth is Not Set");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Enter The Date Of Joining. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddStaff().selectDateOfJoining("1", 4, "2018"),
					"Enter The Date Of Joining is Not Set");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Enter The Professional mail.");
		pages.getAddStaff().enterTheProfessionalEmail("AutomationTest123@gmail.com");

		ReportGenerator.getExtentReport().log(Status.INFO, "Enter The Date Of Joining. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddStaff().selectDateOfSalary("1", 4, "2012"),
					"Enter The Date Of Joining is Not Set");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked on save button.");
		pages.getAddStaff().clickOnSaveButton();

	}

	@Test
	public void searchCreatedStaff() {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddStaff().getURL(prop.URL());

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddStaff().SetEmailAndPassword(prop.UserName(), prop.PWD());

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getAddStaff().ClickOnLoginButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Staff Profile Management . ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddStaff().clickOnStaffProfileManagement(),
					"Staff Profile Management Is Not Clicked");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getEditStaff().searchStaff("Automation 1");

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked on save button.");
		pages.getEditStaff().clickOnSearchButton();

	}

	@Test
	public void feeConfiguration() {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddStaff().getURL(prop.URL());

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddStaff().SetEmailAndPassword(prop.UserName(), prop.PWD());

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getAddStaff().ClickOnLoginButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On fee Configuration. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getFeeConfiguration().clickOnFeeConfiguration(), "fee Configuration Not Clicked");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Search Button. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getFeeConfiguration().searchStudent(200011312), "Search Button Not Clicked");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Pending Invoice.");
		pages.getFeeConfiguration().clickOnPendingInvoice();

		ReportGenerator.getExtentReport().log(Status.INFO, "Select Payment Mode.");
		pages.getFeeConfiguration().selectPaymentMode("Cash");

		ReportGenerator.getExtentReport().log(Status.INFO, "Select Payment Mode.");
		pages.getFeeConfiguration().clickOnPayButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Download Reciept. ");
		RetryUtil.retry(() -> {
			Assert.assertFalse(pages.getFeeConfiguration().clickOnDownloadReciept(), "Download Reciept Not Clicked");
			;
			return null;
		}, 10);
	}
}
