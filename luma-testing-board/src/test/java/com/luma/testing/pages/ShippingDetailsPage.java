package com.luma.testing.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingDetailsPage extends BasePage{
	
	public static final Logger logger=LogManager.getLogger(ShippingDetailsPage.class);
	
	@FindBy(xpath = "//table//tr[1]//td[1]/input")
	WebElement flatRateRadioBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextButton;
	
	public OrderReviewPage selectFlatRateShipping() {
		flatRateRadioBtn.click();
		logger.info("Selecting shipping rate.");
		nextButton.click();
		return new OrderReviewPage();
	}

}
