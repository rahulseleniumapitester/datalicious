package com.automation.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class Baselib {
public static WebDriver driver;

public static void setup(){
	try{
		if(GenericLib.getproperties(GenericLib.config, "Browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
			
		}
		else if(GenericLib.getproperties(GenericLib.config, "Browser").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "");
		}
		else if(GenericLib.getproperties(GenericLib.config, "Browser").equalsIgnoreCase("Internetexplorere")){
			System.setProperty("webdriver.gecko.driver", "");
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

	public  void loadURL()
	{
		try{
			driver.get(GenericLib.getproperties(GenericLib.config, "URL"));
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}catch(AssertionError e){
			throw e;
		}	
	}
	
}


