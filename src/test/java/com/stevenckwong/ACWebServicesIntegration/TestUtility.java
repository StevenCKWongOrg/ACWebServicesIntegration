package com.stevenckwong.ACWebServicesIntegration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUtility {
	
	// This is a utility object used by Test Cases
	
	private String apikey;

	
	public TestUtility() {
		apikey = "_fkTPqTeS62D6PfCEbDViMRT2lotBkskiBlxd677GM";
	}
	
	
	public String getTestApiKey() {
		return apikey;
	}
	
	public WebDriver launchWebDriver() {
		// Make sure you run "mvn" with "-DChromeDriverLocation=<actual_chromedriver_location>" 
		
		// Parameterizing the location of ChromeDriver as some developers are on Mac and some on Windows
		
		String chromeDriverLocation = System.getProperty("ChromeDriverLocation");
		
		if (chromeDriverLocation==null) {
			System.out.println("ChromeDriverLocation not set. Please set with -DChromeDriverLocation=<actual-chromedriver-location-path>");
			chromeDriverLocation = "/opt/chromedriver";
		}
		
		// System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
		System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/ACWebServicesIntegration/index.jsp");
		
		return driver;
	}
	
}
