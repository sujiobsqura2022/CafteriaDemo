package com.obs.utils;

public class AutomationConstants {
	// =========> Generic
		public static final String DRIVER_MISSING = "Driver missing";
		public static final String MISSING_MESSAGE = "is missing";
		public static final String VERIFICATION_FAILED = "Verification failed";
		public static final String OBJECT_NOT_FOUND = "Unable to locate ";
		public static final String TEST_ENVIRONMENT = "testEnvironment";
		public static final String ELEMENT_NOT_FOUND = "not found";
		public static final String EXECUTION_STOP_MESSAGE = "Hence execution stopped...";
		public static final String CAUSE = "Cause of the Exception : ";
		public static final String APPLICATION_URL = "URL";
		public static final String EXCEPTION_MESSAGE_FOR_LOAD_URL = "Cannot navigate to invalid URL, please specify valid URL";

		// =========> Browser Related
		public static final String BROWSERNAME = "browsername";
		public static final String BROWSERNAME_MISSING = "Specify the Browser Name in the config properties file";
		public static final String CHECKBROWSER_MESSAGE = "Please check the Browser Name.. Looks like the browser name is not valid";

		
		
		
		
		public static final String USEFRNAME ="admin";
		public static final String PASSWORD ="password";
		public static final String screenShot_path= System.getProperty("user.dir") + "\\Screenshots\\";
		public static final int EXPLICIT_WAIT = 30;
		public static final int IMPLICIT_WAIT = 10;
		public static final int IMPLICIT_WAIT1 = 10;
		public static final int IMPLICIT_WAIT2 = 2000;
		public static final int FLUENT_WAIT = 30;
		
		public static final String propertyConfig_File=System.getProperty("user.dir")+"\\Configuration\\config.properties";
		public static final String testData="\\src\\test\\resources\\ExcelTestData\\testData.xlsx";
		public static final String dataProvider_filepath=System.getProperty("user.dir")+testData;	


	
}

