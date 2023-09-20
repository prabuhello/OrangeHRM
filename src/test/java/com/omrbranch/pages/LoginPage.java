package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.lib.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	


	/**
	* New thing aaa
	*/
	
	@FindBy( css = "[data-testid=omrlogo]")
	private WebElement imgLogo;
	
	/**
	 * @return
	 */
	public WebElement getImgLogo() {
		return isAvailabe(imgLogo);
	}
	
	
	/**
	 * @return
	 */
	public boolean isLogoVisible() {
		return isDisplay(imgLogo);
	}

}
