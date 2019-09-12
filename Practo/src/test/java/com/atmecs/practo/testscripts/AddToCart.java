package com.atmecs.practo.testscripts;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.practo.helpers.ReadPropertiesFile;
import com.atmecs.practo.pages.PageActions;
import com.atmecs.practo.testbase.InvokeBrowser;
import com.atmecs.practo.utils.ValidateTestResult;

public class AddToCart extends InvokeBrowser {
	String xpath;
	String cssSelector;

	@Test(priority = 1)
	public void diagnostics() throws Exception {

		ReadPropertiesFile read = new ReadPropertiesFile();

		xpath = read.readPropertiesFile("loc.btn.diagnostics.xpath");
		PageActions.ClickElement(driver, xpath);

		xpath = read.readPropertiesFile("loc.field.selectanycityorlocality.xpath");
		PageActions.ClickElement(driver, xpath);
		Thread.sleep(3000);
		xpath = read.readPropertiesFile("loc.field.searchfortestsandprofiles.xpath");
		PageActions.ClickElement(driver, xpath);
		Thread.sleep(3000);

//To select CBC Test

		// driver.findElement(By.cssSelector("#omniSearch")).sendKeys("CBC Test");
		cssSelector = read.readPropertiesFile("loc.field.cbctest.cssselector");
		PageActions.cssSendKeys(driver, cssSelector, "CBC Test");
		// driver.findElement(By.cssSelector("cssSelector")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

// Click on Add(CBC Test) to Cart

		xpath = read.readPropertiesFile("loc.btn.addtocartclick.xpath");
		PageActions.clickOnElement(driver, xpath);
		Thread.sleep(3000);

//Remove previous search(CBC Test)
		xpath = read.readPropertiesFile("loc.select.removesymbolcbctest.xpath");
		PageActions.clickOnElement(driver, xpath);
		Thread.sleep(7000);

// To select Serium Lipase 
		cssSelector= read.readPropertiesFile("loc.field.selecttestsseriumlipase.cssselector");
		Thread.sleep(3000);
		PageActions.cssSendKeys(driver, cssSelector, "Serum Lipase");
		Thread.sleep(7000);

//Click on Add (serium Lipase) to Cart
		xpath = read.readPropertiesFile("loc.addseriumlipasetocart.xpath");
		Thread.sleep(3000);
		PageActions.clickOnElement(driver, xpath);
		Thread.sleep(3000);

//To remove the last search(SeriumLipase)
		cssSelector = read.readPropertiesFile("loc.select.removesymbolseriumlipase.cssselector");
		PageActions.clickOnElement(driver, cssSelector);

// To select T3 T4 TSH test
		cssSelector = read.readPropertiesFile("loc.select.t3t4tsh.cssselector");
		Thread.sleep(3000);
		PageActions.cssSendKeys(driver, cssSelector, "T3 T4 TSH");
		Thread.sleep(5000);

// Click on Add(T3 T4 TSH) to Cart
		cssSelector = read.readPropertiesFile("loc.btn.addtocartt3t4tsh.cssselector");
		Thread.sleep(3000);
		PageActions.clickOnElement(driver, cssSelector);
		Thread.sleep(3000);
	}

// Validatation of names after adding test samples

	@Test(priority = 2)
	public void nameOfSamplesEqual() {
		String firstsample = driver.findElement(By.xpath("//div[text()='Complete Blood Count Automated Blood']"))
				.getText();
		ValidateTestResult.validateData(firstsample, "Complete Blood Count Automated Blood",
				"Names are equals and test passed");
		String secondsample = driver.findElement(By.xpath("//div[text()='Lipase Blood']")).getText();
		ValidateTestResult.validateData(secondsample, "Lipase Blood", "Names are equals and test passed");
		String thirdsample = driver.findElement(By.xpath("//div[text()='Thyroid Profile Total Blood']")).getText();
		ValidateTestResult.validateData(thirdsample, "Thyroid Profile Total Blood", "Names are equals and test passed");

	}

	// Validatation of no. of items added to the cart

	@Test(priority = 3)
	public void numberOfTestsEqual() {
		String tests = driver.findElement(By.xpath("//span[text()='3 Tests']")).getText();
		ValidateTestResult.validateData(tests, "3 Tests", "Tests are equals and test passed");
	}

	// Validatation of individual price after adding test samples

	@Test(priority = 4)
	public void individualSamplePriceEqual() {
		String firstsampleprice = driver.findElement(By.xpath("//span[text()='300']")).getText();
		ValidateTestResult.validateData(firstsampleprice, "300", "Price is equal and test passed");

		String secondsampleprice = driver.findElement(By.xpath("//span[text()='340']")).getText();
		ValidateTestResult.validateData(secondsampleprice, "340", "Price is equal and test passed");

		String thirddsampleprice = driver.findElement(By.xpath("//span[text()='400']")).getText();
		ValidateTestResult.validateData(thirddsampleprice, "400", "Price is equal and test passed");

	}

// Validation of pickup charge after adding samples

	@Test(priority = 5)
	public void pickUpChargeEqual() {
		String pickupcharge = driver.findElement(By.xpath("//span[text()='0']")).getText();
		ValidateTestResult.validateData(pickupcharge, "₹ 0", "Price equals and test passed");
	}
//Validation of total price after adding samples

	@Test(priority = 6)
	public void initialTotalPriceEqual() {

		String price = driver.findElement(By.xpath("//span[text()='1040']")).getText();
		ValidateTestResult.validateData(price, "₹ 1040", "Price equals and test passed");

	}

}
