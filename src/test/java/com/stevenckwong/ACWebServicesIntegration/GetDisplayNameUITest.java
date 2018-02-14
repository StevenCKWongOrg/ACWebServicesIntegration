package com.stevenckwong.ACWebServicesIntegration;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import org.junit.Test;

public class GetDisplayNameUITest {
	
	@Test
	public void testGetDisplayName() {
		// fail("Not yet implemented");
		
		// return;
		
		// This is an integration test. Commented out to return a stubbed test for now
		// while I figure out how to run a JUnit test in integration-test and not have it run 
		// during unit test phase in Maven.
		
		try {
			this.testDisplayName();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Test
	public void testGetFirstName() {
		// fail("Not yet implemented");
		
		// return;
		
		// This is an integration test. Commented out to return a stubbed test for now
		// while I figure out how to run a JUnit test in integration-test and not have it run 
		// during unit test phase in Maven.
		
		try {
			this.testFirstName();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}	

	@Test
	public void testGetLastName() {
		// fail("Not yet implemented");
		
		// return;
		
		// This is an integration test. Commented out to return a stubbed test for now
		// while I figure out how to run a JUnit test in integration-test and not have it run 
		// during unit test phase in Maven.
		
		try {
			this.testLastName();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}	


	
	private WebDriver launchWebDriver() {
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
	
	
	private void testDisplayName() throws InterruptedException {
		
		WebDriver driver = this.launchWebDriver();
		driver.get("http://localhost:8080/ACWebServicesIntegration/index.jsp");
		
		WebElement usernameBox = driver.findElement(By.name("username"));
		usernameBox.clear();
		usernameBox.sendKeys("tm1-b1@stevenckwong.com");
		
		WebElement apikeyBox = driver.findElement(By.name("apikey"));
		apikeyBox.clear();
		apikeyBox.sendKeys("_x3imUPkjQdiySkvNCrs0d03TiJhzCkkEmswt6fpHOao"); // good API Key
		// apikeyBox.sendKeys("_x3imUPkjQdiySkvNCrs0d03TiJhzCkkEmswt6fpHOxx"); // bad API Key
		
		//WebElement loginButton = driver.findElement(By.name("loginbutton"));
		WebElement loginButton = driver.findElement(By.id("getDisplayNameButton"));
		loginButton.click();
		
		Thread.sleep(3000);
		WebElement hiddenDisplayName = driver.findElement(By.id("displayName"));
		String displayName = hiddenDisplayName.getAttribute("value");
		try {
			assertEquals("I'm Team Member 1 for B1",displayName);
			// assertEquals("I'm Team Member 1 for B1 -- FAILTHIS ",displayName); // uncomment this line to fail test
		} catch (org.junit.ComparisonFailure cfe) {
			System.out.println("======JUNIT TEST FAIL======");
			System.out.println("Exception Message:");
			System.out.println(cfe.getMessage());
			System.out.println("+++++++++++++++++++++++++++");
			throw cfe;
		} finally {
			driver.close();
			driver.quit();
		}		
		
	}
	
	private void testFirstName() throws InterruptedException {
		
		WebDriver driver = this.launchWebDriver();
		driver.get("http://localhost:8080/ACWebServicesIntegration/index.jsp");
		
		WebElement usernameBox = driver.findElement(By.name("username"));
		usernameBox.clear();
		usernameBox.sendKeys("tm1-b1@stevenckwong.com");
		
		WebElement apikeyBox = driver.findElement(By.name("apikey"));
		apikeyBox.clear();
		apikeyBox.sendKeys("_x3imUPkjQdiySkvNCrs0d03TiJhzCkkEmswt6fpHOao"); // good API Key
		// apikeyBox.sendKeys("_x3imUPkjQdiySkvNCrs0d03TiJhzCkkEmswt6fpHOxx"); // bad API Key
		
		//WebElement loginButton = driver.findElement(By.name("loginbutton"));
		WebElement loginButton = driver.findElement(By.id("getDisplayNameButton"));
		loginButton.click();
		
		Thread.sleep(3000);
		
		WebElement hiddenFirstName = driver.findElement(By.id("firstName"));
		String firstName = hiddenFirstName.getAttribute("value");
		System.out.println("First Name: " + firstName);
		try {
			assertEquals("TM 1 for Team B1",firstName);
			// assertEquals("TM 1 for Team B1 -- FAILTHIS",firstName); //uncomment this line to fail the test
			
		} catch (org.junit.ComparisonFailure cfe) {
			System.out.println("======JUNIT TEST FAIL======");
			System.out.println("Exception Message:");
			System.out.println(cfe.getMessage());
			System.out.println("+++++++++++++++++++++++++++");
			throw cfe;
		} finally {
			driver.close();
			driver.quit();
		}
				
	}
	
	private void testLastName() throws InterruptedException {
		
		WebDriver driver = this.launchWebDriver();
		driver.get("http://localhost:8080/ACWebServicesIntegration/index.jsp");
		
		WebElement usernameBox = driver.findElement(By.name("username"));
		usernameBox.clear();
		usernameBox.sendKeys("tm1-b1@stevenckwong.com");
		
		WebElement apikeyBox = driver.findElement(By.name("apikey"));
		apikeyBox.clear();
		apikeyBox.sendKeys("_x3imUPkjQdiySkvNCrs0d03TiJhzCkkEmswt6fpHOao"); // good API Key
		// apikeyBox.sendKeys("_x3imUPkjQdiySkvNCrs0d03TiJhzCkkEmswt6fpHOxx"); // bad API Key
		
		//WebElement loginButton = driver.findElement(By.name("loginbutton"));
		WebElement loginButton = driver.findElement(By.id("getDisplayNameButton"));
		loginButton.click();
		
		Thread.sleep(3000);
		
		WebElement hiddenLastName = driver.findElement(By.id("lastName"));
		String lastName = hiddenLastName.getAttribute("value");
		System.out.println("Last Name: " + lastName);
		try {
			assertEquals("Simplicity",lastName);
			// assertEquals("TM 1 for Team B1 -- FAILTHIS",firstName); //uncomment this line to fail the test
			
		} catch (org.junit.ComparisonFailure cfe) {
			System.out.println("======JUNIT TEST FAIL======");
			System.out.println("Exception Message:");
			System.out.println(cfe.getMessage());
			System.out.println("+++++++++++++++++++++++++++");
			throw cfe;
		} finally {
			driver.close();
			driver.quit();
		}
				
	}	
}

