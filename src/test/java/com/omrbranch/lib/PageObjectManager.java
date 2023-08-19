package com.omrbranch.lib;

import com.omrbranch.pages.LoginPage;

public class PageObjectManager {

	private LoginPage loginPage;
	private static PageObjectManager pageObjectManager;

	private PageObjectManager() {

	}

	public static PageObjectManager getPageObjectManager() {
		return pageObjectManager == null ? pageObjectManager = new PageObjectManager() : pageObjectManager;
	}

	/**
	 * Use this method to get object of LoginPage
	 * 
	 * @return login page object
	 */
	public LoginPage getLoginPage() {
		return loginPage == null ? loginPage = new LoginPage() : loginPage;
	}

}
