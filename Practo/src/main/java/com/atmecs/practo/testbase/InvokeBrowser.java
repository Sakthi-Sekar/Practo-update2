package com.atmecs.practo.testbase;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.practo.helpers.ReadPropertiesFile;

public class InvokeBrowser {
	protected static WebDriver driver;
	Properties config = new Properties();
	ReadPropertiesFile read=new ReadPropertiesFile(); 

	@BeforeTest
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sakthi.sekar\\eclipse-workspace\\Practo\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(read.readPropertiesFile("url"));
		driver.manage().window().maximize();
	}
}