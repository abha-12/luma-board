package com.luma.testing.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderReviewPage extends BasePage {

	public static final Logger logger = LogManager.getLogger(OrderReviewPage.class);

	@FindBy(xpath = "//div[@class='primary']/button[@class='action primary checkout']")
	WebElement placeOrderBtn;

	public OrderConfirmationPage clickPlaceOrder() {
		// WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		// wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", placeOrderBtn);
		logger.info("Reviewing and placing order.");
		// placeOrderBtn.click();
		return new OrderConfirmationPage();
	}

}
