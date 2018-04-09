package com.stevenckwong.ACWebServicesIntegration;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ListIterator;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GetTestCaseDetailsUITest {

	@Test
	public void test() {
		// fail("Not yet implemented");
		try {
			this.testGetTestCaseByID();
			this.testGetTestCaseByTestName();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	
	private void testGetTestCaseByID() throws InterruptedException {
		
		TestUtility testUtil = new TestUtility();
		
		WebDriver driver = testUtil.launchWebDriver();
		
		String inputTestCaseID = "TC47";
		String inputColour = "hotpink";
		
		driver.get("http://localhost:8080/ACWebServicesIntegration/index-gettestcasedetails.jsp");
		
		WebElement testCaseIDBox = driver.findElement(By.name("testcaseid"));
		testCaseIDBox.clear();
		testCaseIDBox.sendKeys(inputTestCaseID);
		
		Select colourSelection = new Select(driver.findElement(By.name("panelColour")));
		colourSelection.selectByValue(inputColour);
		
		WebElement getTestCaseButton = driver.findElement(By.id("getTestCaseDetailsByIDButton"));
		getTestCaseButton.click();

		Thread.sleep(3000);
		WebElement hiddenTCFormattedID = driver.findElement(By.name("tcFormattedID"));
		String formattedID = hiddenTCFormattedID.getAttribute("value");
		WebElement panelColourHiddenElement = driver.findElement(By.name("panelColour"));
		String colour = panelColourHiddenElement.getAttribute("value");
		
		try {
			assertEquals(inputTestCaseID,formattedID);
			// assertEquals("I'm Team Member 1 for B1 -- FAILTHIS ",displayName); // uncomment this line to fail test
			assertEquals(colour,inputColour);
			
		} catch (org.junit.ComparisonFailure cfe) {
			throw cfe;
		} finally {
			driver.close();
			driver.quit();
		}		
	}
	
	
	private void testGetTestCaseByTestName() throws InterruptedException {
		
		TestUtility testUtil = new TestUtility();
		
		WebDriver driver = testUtil.launchWebDriver();
		
		String inputTestCaseName = "Test Get Display Name with an invalid user";
		String inputColour = "floralwhite";
		
		driver.get("http://localhost:8080/ACWebServicesIntegration/index-gettestcasedetails.jsp");
		
		WebElement testCaseIDBox = driver.findElement(By.name("testcasename"));
		testCaseIDBox.clear();
		testCaseIDBox.sendKeys(inputTestCaseName);
		
		Select colourSelection = new Select(driver.findElement(By.name("panelColour")));
		colourSelection.selectByValue(inputColour);
		
		WebElement getTestCaseButton = driver.findElement(By.id("getTestCaseDetailsByNameButton"));
		getTestCaseButton.click();

		Thread.sleep(3000);
		WebElement hiddenTCFormattedID = driver.findElement(By.name("tcFormattedID"));
		String formattedID = hiddenTCFormattedID.getAttribute("value");
		WebElement panelColourHiddenElement = driver.findElement(By.name("panelColour"));
		String colour = panelColourHiddenElement.getAttribute("value");
		
		try {
			assertEquals("TC40",formattedID);
			// assertEquals("I'm Team Member 1 for B1 -- FAILTHIS ",displayName); // uncomment this line to fail test
			assertEquals(colour,inputColour);
			
		} catch (org.junit.ComparisonFailure cfe) {
			throw cfe;
		} finally {
			driver.close();
			driver.quit();
		}		
	}	
}
