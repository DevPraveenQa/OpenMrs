package com.Listner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BaseClass.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ItestListnerClass extends BaseClass implements ITestListener {

	public String testname;
	public String methodName;

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			ExtentReport_Test.extentTest.pass(result.getMethod().getMethodName() + " : " + "TestPass",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentReport_Test.extentTest.fail(result.getMethod().getMethodName() + " : " + "TestFail",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//
//	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
