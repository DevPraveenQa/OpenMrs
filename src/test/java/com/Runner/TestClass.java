package com.Runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.BaseClass.Browsers;

public class TestClass extends BaseClass {
	
	
	@Test(priority = -2)
	private void browser() {
       
		browserLauncher("chrome");
		getUrl("https://www.amazon.in/");
		
	}
	@Test(priority = -1)
	private void getUrl() {
       WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
       sendkeys(driver, element,"apple");
		
	}
@Test(priority = 3)
	private void closea() {
       Quite();
	}
}
