package com.orangehrm.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * The {<code></code> Date : 18-08-2023
 * 
 * @author Mayusri The {@code Properties} class is repsented
 * 
 */
public class BaseClass {

	private static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(BaseClass.class);
	/**
	 * This method returns path of the current working directory
	 * 
	 * @return string of current directory.
	 */
	private String getCurrentWorkingDirPath() {
		return System.getProperty("user.dir");
	}

	/**
	 * Use this method to get value from configuration file
	 * @param key - which is presented in configuration file.
	 * @return value of specified key
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getValueFrmPropertyFile(String key) throws FileNotFoundException, IOException {
		
		Properties properties = new Properties();
		properties.load(new FileInputStream(
				new File(getCurrentWorkingDirPath() + "\\src\\test\\resources\\configuration\\config.properties")));
		String value = properties.getProperty(key);
		logger.info("Read the value from config file(key,value):("+key+":"+value+")");
		return value;
	}

	/**
	 * Use this method to wait the execution specified time
	 */
	public void staticWait() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Use this method to close the current driver session
	 */
	public void quitBrowser() {
		staticWait();
		logger.info("Quit the browser");
		System.out.println("Quit the browser");
		driver.close();
	}

	/**
	 * User this method to launch the browser specified in configuration file 
	 * @throws FileNotFoundExcepton
	 * @throws IOException
	 */
	public void launchBrower(String browser) throws FileNotFoundException, IOException {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		  default:
			  logger.error(browser+" is invalid");
			  throw new RuntimeException("Invalild browser"+ browser);
		}
		logger.info(browser+ " is launched successfully.");
	}
	
	/**
	 * Use this method to maximize the current window
	 */
	public void maximizeWindow() {
		Options manage = driver.manage();
		Window window = manage.window();
		window.maximize();
		logger.info("Launched browser window is maximizied..");
		System.out.println("Launched Browser window is  maximizied");
	}
	
	/**
	 * Use this method to navigate to Specified URL
	 * @param url  -  navigate to URL
	 */
	public void gotoUrl(String url) {
		driver.get(url);
	}
}
