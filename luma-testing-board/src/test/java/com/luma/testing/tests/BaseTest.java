package com.luma.testing.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.luma.testing.listener.LumaListener;
import com.luma.testing.pages.BasePage;
import com.luma.testing.utils.PropertyReader;

@Listeners(LumaListener.class)
public class BaseTest {
	public static final Logger logger = LogManager.getLogger(BaseTest.class);
	protected static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void init() {
		// Initializing the webdriver for the selected browser

		if (PropertyReader.retrieveProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://Users//kumar//Desktop//chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("ChromeDriver initialized.");
		} else if (PropertyReader.retrieveProperty("browser").equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C://Users//kumar//Desktop//msedgedriver.exe");
			driver = new EdgeDriver();
			logger.info("EdgeDriver initialized.");
		}
		BasePage.driver = driver;
		LumaListener.driver = driver;

	}

	@AfterSuite
	public void cleanup() {
		driver.quit();
	}

}
