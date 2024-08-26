package com.Runner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.BaseClass.BaseClass;
import com.Listner.ExtentReport_Test;
import com.Listner.ItestListnerClass;
import com.aventstack.extentreports.ExtentTest;
import com.pom.Amazon1LoginPage;

@Listeners(ItestListnerClass.class)
public class AmazonRunner extends BaseClass {
	public static WebDriver amazanRunnerDriver;

	@BeforeSuite
	public void extendReportStart() {
		extentReportStart("C:\\Users\\DELL\\Vadapalani_Java\\OpenMrs\\ReportsSS");

	}

	@BeforeTest
	public static void browser() {
		amazanRunnerDriver = BaseClass.browserLauncher("chrome");
	}

	@Test(priority = 5)
	public static void validLoginTest() {

		ExtentReport_Test.extentTest = extentReports
				.createTest("LoginTest ; " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("valid email id with valid password");
		Amazon1LoginPage a1 = new Amazon1LoginPage(amazanRunnerDriver);
		Assert.assertTrue(a1.validLogin(ExtentReport_Test.extentTest));

	}

	@Test(priority = 2)
	public static void validEmailIncorrPass() {
		ExtentReport_Test.extentTest = extentReports
				.createTest("LoginTest ; " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("valid email id with invalid password");
		Amazon1LoginPage a1 = new Amazon1LoginPage(amazanRunnerDriver);
		a1.validEmailInvalidPass();

	}
	@Test(priority = 3)
	public static void testemptyEmail() {
		ExtentReport_Test.extentTest = extentReports
				.createTest("LoginTest ; " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Empty Email and verify");
		Amazon1LoginPage a1 = new Amazon1LoginPage(amazanRunnerDriver);
		a1.emptyEmail();
	}

	@AfterTest
	public void closeBrowser() {
		Quite();

	}

	@AfterSuite
	public void extendReportEnd() {
		extentReportTearDown("C:\\Users\\DELL\\Vadapalani_Java\\OpenMrs\\ReportsSS\\index.html");

	}
}
