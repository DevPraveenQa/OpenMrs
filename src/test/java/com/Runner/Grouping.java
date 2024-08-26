package com.Runner;

import org.testng.annotations.Test;

public class Grouping {
	@Test(groups = "manualTester")
	public void Yaasar() {
      System.out.println("manualTester Yasar");
	}
	@Test(groups = "manualTester")
    public void ragu() {
		System.out.println("manualTester ragu");
	}	
	@Test(groups = "automationTester")
    public void ponnivalavan() {
		System.out.println("automationTester ponnivalavan");
	}
	@Test(groups = "automationTester")
    public void praveen() {
		System.out.println("automationTester Praveen");
	}
	@Test(groups = "webDevelepor")
    private void vishnu() {
System.out.println("webDevelepor Vishnu");
	}
	@Test(groups = "webDevelepor")
    public void saran() {
System.out.println("webDevelepor Saran");
	}
	
	

}
