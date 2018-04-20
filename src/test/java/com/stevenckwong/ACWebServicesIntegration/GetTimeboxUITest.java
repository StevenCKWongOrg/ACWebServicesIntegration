package com.stevenckwong.ACWebServicesIntegration;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import org.junit.Test;

public class GetTimeboxUITest {
	

	private WebDriver launchWebDriver() {
		
		TestUtility testUtil = new TestUtility();
		
		return testUtil.launchWebDriver();
	}
	
	@Test
	public void testGetIterationForProject() {
		
		try {
		
			WebDriver driver = this.launchWebDriver();
			driver.get("http://localhost:8080/ACWebServicesIntegration/index-timeboxmanagement.jsp");
			
			WebElement projectNameEditBox = driver.findElement(By.name("projectName"));
			projectNameEditBox.clear();
			projectNameEditBox.sendKeys("Online Store");
					
			WebElement getTimeboxButton = driver.findElement(By.id("getTimeboxesButton"));
			getTimeboxButton.click();
			
			Thread.sleep(3000);
			boolean timeboxNameFound = true;
			
			try {
				WebElement timeboxNameHidden = driver.findElement(By.name("Iteration 3"));
			} catch (NoSuchElementException ne) {
				timeboxNameFound = false;
			}
			
			try {
				assertEquals(true,timeboxNameFound);
				// assertEquals("I'm Team Member 1 for B1 -- FAILTHIS ",displayName); // uncomment this line to fail test
			} catch (org.junit.ComparisonFailure cfe) {
				throw cfe;
			} finally {
				driver.close();
				driver.quit();
			}		
			
		
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} 
	}
}

