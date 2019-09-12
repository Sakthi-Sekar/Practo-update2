package com.atmecs.practo.helpers;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;

import com.atmecs.practo.constants.ConstantPaths;



public class ReadPropertiesFile {
	public String readPropertiesFile(String elements) throws FileNotFoundException {
		Properties prop = new Properties();
	

		FileInputStream input = new FileInputStream(ConstantPaths.CONFIG_FILE);
		FileInputStream practolocators = new FileInputStream(ConstantPaths.LOCATORS_FILE);
		
		try {
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			prop.load(practolocators);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String data = prop.getProperty(elements);
		return data;

	}
}
