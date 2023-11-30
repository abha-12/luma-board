package com.luma.testing.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public static final Logger logger = LogManager.getLogger(HomePage.class);

	@FindBy(linkText = "Sign In")
	WebElement signInLink;

	@FindBy(xpath = "//li[@class='greet welcome']")
	WebElement welcomeText;

	@FindBy(linkText = "Gear")
	WebElement gearLink;

	@FindBy(id = "ui-id-25")
	WebElement bagsLink;

	public boolean isPageLoaded() {
		return driver.getTitle().equals("Home Page");
	}

	public boolean isSignInLinkPresent() {
		return signInLink.isDisplayed();
	}

	public LoginPage clickSignIn() {
		signInLink.click();
		return new LoginPage();
	}

	public boolean isLoggedIn() {
		return welcomeText.isDisplayed();
	}

	public void mouseHoverGear() {
		actions.moveToElement(gearLink).perform();
		logger.info("Hovering over 'Gear' category.");
	}

	public BagsPage clickOnBags() {
		bagsLink.click();
		logger.info("Selected Bags category.");
		return new BagsPage();
	}

}
