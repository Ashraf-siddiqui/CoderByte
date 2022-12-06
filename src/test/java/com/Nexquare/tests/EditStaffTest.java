package com.Nexquare.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Extras.ReportGenerator;
import Extras.RetryUtil;

@Listeners(Extras.Listeneres.class)

public class EditStaffTest extends BaseTest {

	@Test
	public void searchCreatedStaff() {
		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Edit Staff. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getEditStaff().clickOnStaffEdit(), "Staff Edit Not Clicked");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getEditStaff().searchStaff("Automaton 1");
	}

}
