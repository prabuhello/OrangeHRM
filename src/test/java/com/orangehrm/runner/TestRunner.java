package com.orangehrm.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.orangehrm.lib.BaseClass;


public class TestRunner extends BaseClass {

	@BeforeClass
	public void beforeClass() throws FileNotFoundException, IOException {
		launchBrower(getValueFrmPropertyFile("browser").trim().toLowerCase());
		maximizeWindow();
		gotoUrl(getValueFrmPropertyFile("URL").trim().toLowerCase());
	}
	
	
	@Test
	public void  isLogoVisible() {
		System.out.println("method1");
			
	}
	
	
	@Test
	public void  isLogoVisible1() {
		System.out.println("Method2");
	}
	
	@AfterClass
	public void afterTest() {
		System.out.println("Quit the browser");
			quitBrowser();
	}

}
