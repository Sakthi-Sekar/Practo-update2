package com.atmecs.practo.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.practo.testbase.InvokeBrowser;



public class DropDown extends InvokeBrowser
{
	public static void dropdown(String id, int value) {
		WebElement mySelectElement = driver.findElement(By.xpath(id));
		Select topsclr = new Select(mySelectElement);
		topsclr.selectByIndex(value);
	}
}
