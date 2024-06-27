package com.luma.testing.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BagsPage extends GearPage {

	public static final Logger logger = LogManager.getLogger(BagsPage.class);

	// List of WebElements sorted by price
	@FindBy(xpath = "//span[@data-price-type='finalPrice']")
	List<WebElement> productsByPrice;

	@FindBy(id = "sorter")
	WebElement sortByBox;

	@FindBy(xpath = "//div[contains(text(),'Price')]")
	WebElement priceFilter;

	@FindBy(partialLinkText = "$20.00")
	WebElement priceRange20To29;

	@FindBy(xpath = "//div[@class='product-item-info']")
	WebElement firstProduct;

	@FindBy(xpath = "//button[@title='Add to Cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//a[contains(text(),'shopping cart')]")
	WebElement cartButton;

	@FindBy(xpath = "//a/span[contains(text(),'View')]")
	WebElement viewCartBtn;

	public boolean isPageLoaded() {
		return driver.getTitle().equals("Bags - Gear");
	}

	public void sortByPrice() {
		Select sortByDrpDwn = new Select(sortByBox);
		sortByDrpDwn.selectByVisibleText("Price");
		logger.info("Selected Sort By Price.");
	}

	// checking if the list is properly sorted by price.

	public boolean isPriceSortProper() {
		for (int i = 0; i < productsByPrice.size() - 2; i++) {
			if (Integer.parseInt(productsByPrice.get(i).getAttribute("data-price-amount")) > Integer
					.parseInt(productsByPrice.get(i + 1).getAttribute("data-price-amount"))) {
				return false;
			}
		}
		return true;

	}

	public void addFirstProductToCart() {
		actions.moveToElement(firstProduct).perform();
		addToCartBtn.click();
		logger.info("Added the first product in results to cart.");
	}

	public CartPage goToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		cartButton.click();
		logger.info("Navigating to cart page.");

		// JavascriptExecutor executor=(JavascriptExecutor)driver;
		// executor.executeScript("arguments[0].click();", cartButton);
		// cartButton.click();
		// viewCartBtn.click();
		return new CartPage();
	}

}
