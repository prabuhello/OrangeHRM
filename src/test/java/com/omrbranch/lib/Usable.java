package com.omrbranch.lib;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Usable {
	public String getCurrentWorkingDirPath();
	/**
	 * Use this method to get value from configuration file
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public String getValueFrmPropertyFile(String key) throws FileNotFoundException, IOException ;

	
	/**
	 * Use this method to wait the execution specified time
	 */
	public void staticWait();
	
	/**
	 * Use this method to close the current driver session
	 */
	public void quitBrowser();

	/**
	 * User this method to launch the browser specified in configuration file 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void launchBrower(String browser) throws FileNotFoundException, IOException;
	
	/**
	 * Use this method to maximize the current window
	 */
	public void maximizeWindow();
	
	/**
	 * Use this method to navigate to Specified URL
	 * @param url  -  navigate to URL
	 */
	public void gotoUrl(String url) ;
	
	/**
	 * Use this method to check availability of the element
	 * @param element
	 */
	public WebElement isAvailabe(WebElement element) ;
	
	
	/**
	 * Use this method to check the visibility of element
	 * @param element
	 * @return
	 */
	public boolean isDisplay(WebElement element);

	
	public WebDriver getDriver();
}
