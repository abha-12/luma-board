package com.luma.testing.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

	public static final Logger logger = LogManager.getLogger(CartPage.class);

	@FindBy(xpath = "//span[text()='Proceed to Checkout']")
	WebElement checkoutBtn;

	@FindBy(xpath = "//h1[@class='page-title']")
	WebElement shoppingCartTxt;

	public ShippingDetailsPage clickCheckout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(checkoutBtn));
		checkoutBtn.click();
		logger.info("Initiating checkout process.");
		return new ShippingDetailsPage();
	}

	public boolean isPageLoaded() {
		return shoppingCartTxt.isDisplayed();
	}

}
