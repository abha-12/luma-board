package com.luma.testing.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public static final Logger logger=LogManager.getLogger(LoginPage.class);

	@FindBy(name = "login[username]")
	WebElement emailBox;

	@FindBy(id = "pass")
	WebElement passwordBox;

	@FindBy(id = "send2")
	WebElement signInLink;

	public HomePage loginAsValidUser(String email, String password) {
		emailBox.clear();
		emailBox.sendKeys(email);
		logger.info("Entered valid email "+email);
		passwordBox.clear();
		passwordBox.sendKeys(password);
		logger.info("Entered valid password");
		signInLink.click();
		return new HomePage();
	}
	public boolean isPageLoaded() {
		return emailBox.isDisplayed();
	}

}
