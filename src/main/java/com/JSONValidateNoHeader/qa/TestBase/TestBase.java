package com.JSONValidateNoHeader.qa.TestBase;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

	public static Properties prop;
	
	public TestBase() 
	{
		prop=new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("/Users/arka/Documents/workspace/HttpGetMethodsJSONValidateWithHeader/src/main/java/com/JSONValidateNoHeader/qa/Config/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
