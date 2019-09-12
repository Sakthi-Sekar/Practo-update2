package com.atmecs.practo.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.atmecs.practo.utils.ValidateTestResult;

public class ValidationOfPracto  {

	static WebDriver driver;
	// Validatation of names after adding test samples- CBC test sample

	public static void nameEqualCbc() {
		String nametest1 = driver.findElement(By.xpath("//div[text()='Complete Blood Count Automated Blood']"))
				.getAttribute("value");
		ValidateTestResult.validateData(nametest1, "Complete Blood Count Automated Blood",
				"Names are equals and test passed");
	}

	// Validation of Lipase blood sample

	public static void nameEqualLipase() {
		String nametest2 = driver.findElement(By.xpath("//div[text()='Lipase Blood']")).getText();
		ValidateTestResult.validateData(nametest2, "Lipase Blood", "Names are equals and test passed");

	}

	// Validatation of no. of items added to the cart

	public static void testSampleNumberEquals() {
		String tests = driver.findElement(By.xpath("//span[text()='3 Tests']")).getText();
		ValidateTestResult.validateData(tests, "3 Tests", "Tests are equals and test passed");
	}

	// Validatation of total price after adding test samples

	public static void initialtotalPriceAfterAdd() {

		String price = driver.findElement(By.xpath("//span[text()='1040']")).getText();
		ValidateTestResult.validateData(price, "₹ 1040", "Price equals and test passed");

	}

	public static void finalTotalAfterRemoveOfSample() {
		String finalprice = driver.findElement(By.xpath("//span[text()='740']")).getText();
		ValidateTestResult.validateData(finalprice, "₹ 740", "Final Price equals and test passed");
	}
}
