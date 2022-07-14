package com.obs.datahandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyDataHandler {
	
	public static final String currentDir  = System.getProperty("user.dir"); 
	public static String filePath = currentDir + "/src/main/resources/";
 
	
	public Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(filePath+fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	     // System.out.println("username: "+ prop.getProperty("username"));
	     // System.out.println("password: "+ prop.getProperty("password"));
	      return prop;
	      
	      
	      
	      
	      
	      
	      
	      
	   }
}
