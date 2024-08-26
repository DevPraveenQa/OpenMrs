package com.Runner;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.BaseClass.Browsers;

public class CrossBrowser extends BaseClass{
	
	
	@Test(invocationCount = 2)
	private void chrome() {

		browserLauncher("chrome");
		getUrl("https://www.amazon.in/");
		Quite();
		
	}
	@Ignore
	@Test()
	private void edge() {
		browserLauncher("edge");
		getUrl("https://www.amazon.in/");
		Quite();
	}
	@Test(timeOut = 20000)
	private void firefox() {
		browserLauncher("firefox");
		getUrl("https://www.amazon.in/");
		Quite();
	}
	

}
