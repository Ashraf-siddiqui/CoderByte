package com.Nexquare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeeConfiguration extends BasePage {

	public FeeConfiguration(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By Loader = By.xpath("//div[@class='spinner-outer']");

	By FeeConfiguration = By.xpath("//span[normalize-space()='Fee Configuration']");

	By GlobalStudentSearchBox = By.xpath("//input[@id='searchInput']");

	By PendingInvoice = By.xpath(
			"//label[@for='mat-checkbox-1-input']//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']");

	By PaymentMode = By.xpath("//span[@class='mat-select-placeholder ng-tns-c18-107 ng-star-inserted']");

	By PayButton = By.xpath("(//button[@class='submit-btn mat-flat-button mat-button-base mat-accent'])[3]");

	By DownloadReciept = By.xpath("//mat-icon[contains(text(),'save_alt')]");

	public boolean clickOnFeeConfiguration() {
		clickandwait(FeeConfiguration);
		waitforelementtoBecomeVisible(Loader);
		waitforelementtoBecomeInVisible(Loader);
		return isElementPresent(GlobalStudentSearchBox);
	}

	public boolean searchStudent(int id) {
		SetText(GlobalStudentSearchBox, String.valueOf(id));
		PressEnter();
		waitforelementtoBecomeVisible(Loader);
		waitforelementtoBecomeInVisible(Loader);
		return isElementPresent(PendingInvoice);
	}

	public void clickOnPendingInvoice() {
		clickandwait(PendingInvoice);
	}

	public void selectPaymentMode(String Mode) {
		clickandwait(PaymentMode);
		By selectMode = By.xpath("//span[normalize-space()='" + Mode + "']");
		clickandwait(selectMode);

	}

	public void clickOnPayButton() {
		clickandwait(PayButton);
	}

	public boolean clickOnDownloadReciept() {

		clickandwait(DownloadReciept);
		return IsElementPresent(DownloadReciept);
	}
}
