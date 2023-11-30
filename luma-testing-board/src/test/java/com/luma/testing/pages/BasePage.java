package com.luma.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public static WebDriver driver;
	
	
	
	Actions actions=new Actions(driver);
	

	public BasePage() {
		PageFactory.initElements(driver, this);
	}
}
