package com.atmecs.practo.testscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.practo.utils.ValidateTestResult;

public class RemoveFromCart extends AddToCart {

	// Remove CBC Test from the cart

	@Test(priority = 7)
	public void cartAfterRemovalOfSample() throws Exception {
		driver.findElement(By.cssSelector(
				"#root-app > div > div > div:nth-child(2) > div > div.dg-wrapper.u-padb--dbl > div > div > div > div.c-group-details-wrapper > div > div > div.dg-three.dg-last > div > div > div.c-shopping-cart__lower-wrapper > div > div:nth-child(1) > div.o-listitem__wrap--primary.c-testitem__wrap--primary > div.o-listitem__secondary.c-testitem__secondary > div > i"))
				.click();
		Thread.sleep(3000);
	}

	// Validation of total price after removing one sample test

	@Test(priority = 8)
	public void validateCartAfterRemoval() {

		// Validation for names of remaining samples in cart after removal
		String sample1 = driver.findElement(By.xpath("//div[text()='Lipase Blood']")).getText();
		ValidateTestResult.validateData(sample1, "Lipase Blood", "Names are equals and test passed");
		String sample2 = driver.findElement(By.xpath("//div[text()='Thyroid Profile Total Blood']")).getText();
		ValidateTestResult.validateData(sample2, "Thyroid Profile Total Blood", "Names are equals and test passed");

		// Validation for no.of tests in cart

		String testcounts = driver.findElement(By.xpath("//span[text()='2 Tests']")).getText();
		ValidateTestResult.validateData(testcounts, "2 Tests", "Tests are equals and test passed");

		// Validation of remaining samples individual prices

		String secondsampleprice = driver.findElement(By.xpath("//span[text()='340']")).getText();
		ValidateTestResult.validateData(secondsampleprice, "340", "Price is equal and test passed");

		String thirddsampleprice = driver.findElement(By.xpath("//span[text()='400']")).getText();
		ValidateTestResult.validateData(thirddsampleprice, "400", "Price is equal and test passed");

		// Validation of pickup charge after removal of one sample from cart

		String pickupcharge = driver.findElement(By.xpath("//span[text()='0']")).getText();
		ValidateTestResult.validateData(pickupcharge, "₹ 0", "Price equals and test passed");

		// Validation of final total price after removal of one sample

		String finalcharge = driver.findElement(By.xpath("//span[text()='740']")).getText();
		ValidateTestResult.validateData(finalcharge, "₹ 740", "Price equals and test passed");

	}
}