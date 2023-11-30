package com.luma.testing.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LumaListener extends TestListenerAdapter {
	public static final Logger logger = LogManager.getLogger(LumaListener.class);
	public static WebDriver driver;

	public void onTestSuccess(ITestResult r) {
		ITestNGMethod m = r.getMethod();
		String currentMethodName = m.getMethodName();
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File("screenshots/" + currentMethodName + "-success.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info(currentMethodName + " successful.");
	}

	public void onTestFailure(ITestResult r) {
		ITestNGMethod m = r.getMethod();
		String currentMethodName = m.getMethodName();
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File("screenshots/" + currentMethodName + "-failure.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info(currentMethodName + " failed.");
	}

	public void onTestSkipped(ITestResult r) {
		ITestNGMethod m = r.getMethod();
		String currentMethodName = m.getMethodName();
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File("screenshots/" + currentMethodName + "-skip.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info(currentMethodName + " skipped.");
	}

	public void onTestStart(ITestResult r) {
		ITestNGMethod m = r.getMethod();
		String currentMethodName = m.getMethodName();
		logger.info(currentMethodName + " started.");
	}

}
