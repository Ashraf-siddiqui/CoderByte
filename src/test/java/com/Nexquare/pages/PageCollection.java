package com.Nexquare.pages;

import org.openqa.selenium.WebDriver;

public class PageCollection {

	ThreadLocal<WebDriver> driver;

	public PageCollection(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
	}

	private AddStaff addStaff;

	private EditStaff editStaff;

	private FeeConfiguration feeConfiguration;

	public AddStaff getAddStaff() {
		return (addStaff == null) ? addStaff = new AddStaff(driver) : addStaff;

	}

	public EditStaff getEditStaff() {
		return (editStaff == null) ? editStaff = new EditStaff(driver) : editStaff;
	}

	public FeeConfiguration getFeeConfiguration() {
		return (feeConfiguration == null) ? feeConfiguration = new FeeConfiguration(driver) : feeConfiguration;

	}

}