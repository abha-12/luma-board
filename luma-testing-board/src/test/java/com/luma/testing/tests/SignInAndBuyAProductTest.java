package com.luma.testing.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.luma.testing.pages.BagsPage;
import com.luma.testing.pages.CartPage;
import com.luma.testing.pages.HomePage;
import com.luma.testing.pages.LoginPage;
import com.luma.testing.pages.OrderConfirmationPage;
import com.luma.testing.pages.OrderReviewPage;
import com.luma.testing.pages.ShippingDetailsPage;
import com.luma.testing.utils.PropertyReader;

public class SignInAndBuyAProductTest extends BaseTest {
	public static final Logger logger = LogManager.getLogger(SignInAndBuyAProductTest.class);

	HomePage homePage;
	LoginPage loginPage;
	BagsPage bagsPage;
	CartPage cartPage;
	ShippingDetailsPage shippingDetailsPage;
	OrderReviewPage orderReviewPage;
	OrderConfirmationPage orderConfirmationPage;

	@Test
	public void launchTest() {
		String url = PropertyReader.retrieveProperty("url");
		driver.get(url);
		logger.info("Launched url " + url);
		homePage = new HomePage();
		driver.manage().window().maximize();
		
	}

	@Test(dependsOnMethods = "launchTest")
	public void signInTest() {
		// Login to the application with valid credentials

		loginPage = homePage.clickSignIn();
		Assert.assertTrue(loginPage.isPageLoaded(), "Login page not loaded.");

		homePage = loginPage.loginAsValidUser(PropertyReader.retrieveProperty("validEmail"),
				PropertyReader.retrieveProperty("validPassword"));
		Assert.assertTrue(homePage.isPageLoaded(), "Login Failed.");
		logger.info("Successfully logged in.");
	}

	@Test(dependsOnMethods = "signInTest")
	public void selectAProductTest() {
		// Select gear-->bags-->sort by price-->add first product to cart

		homePage.mouseHoverGear();
		bagsPage = homePage.clickOnBags();
		bagsPage.sortByPrice();
		Assert.assertTrue(bagsPage.isPriceSortProper(), "Products not sorted according to price");
		bagsPage.addFirstProductToCart();
		cartPage = bagsPage.goToCart();
		Assert.assertTrue(cartPage.isPageLoaded(), "Cart not loaded.");
	}

	@Test(dependsOnMethods = "selectAProductTest")
	public void checkOutProductTest() {
		shippingDetailsPage = cartPage.clickCheckout();
		orderReviewPage = shippingDetailsPage.selectFlatRateShipping();
		orderConfirmationPage = orderReviewPage.clickPlaceOrder();
	}

}
