package com.Listner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.BaseClass.BaseClass;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReport_Test {

	public static ExtentTest extentTest;

	@BeforeSuite
	public void extendsTestReportStartUp() {

		BaseClass base = new BaseClass();
		base.extentReportStart(null);

	}

	@AfterSuite
	public void extendReportEnd() {
		BaseClass base = new BaseClass();
		base.extentReportStart(null);

	}

}
