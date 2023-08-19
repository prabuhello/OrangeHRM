package com.omrbranch.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.omrbranch.lib.BaseClass;
import com.omrbranch.lib.PageObjectManager;
import com.omrbranch.pages.LoginPage;

import java.lang.reflect.Method;


public class TestRunner extends BaseClass {
 
    	private static final Logger logger = LoggerFactory.getLogger(BaseClass.class);
    	 

    
    @BeforeClass
	public void beforeClass() throws FileNotFoundException, IOException  {
		launchBrower(getValueFrmPropertyFile("browser").toLowerCase());
		maximizeWindow();
		gotoUrl(getValueFrmPropertyFile("url").toLowerCase());
	}
    
    
	@BeforeMethod
    public void beforeMethod( Method m ) {
		System.out.println(m.getName());
    }
	
	@Test(testName = "TC_01_LoginPage")
	public void  isLogoVisible(Method m) {
		logger.info("Check the visibility of element..."+m.getName());
		logger.info("Loginpage object : "+System.identityHashCode(PageObjectManager.getPageObjectManager().getLoginPage()));
		LoginPage loginPage = PageObjectManager.getPageObjectManager().getLoginPage();
		boolean logoVisible = loginPage.isLogoVisible();
		Assert.assertTrue(logoVisible,"Verification of Logo Visibility");
		logger.info("Suceesfully verified:the logo is displayed.");
	}	
	
	@AfterClass
	public void afterTest() {
		System.out.println("Quit the browser");
			quitBrowser();
	}
}
