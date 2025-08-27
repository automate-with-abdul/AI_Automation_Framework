package com.automation.framework.tests.demoqa;

import com.automation.framework.drivermanager.DriverFactory;
import com.automation.framework.frameworkengine.Constants;
import com.automation.framework.pages.DemoQaHomePage;
import com.automation.framework.pages.FormsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DemoQaTests {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initializeWebDriver("chrome");
    }

    @Test
    public void testPracticeFormSubmission() {
        FormsPage formsPage = new DemoQaHomePage()
                .navigateToDemoQaPage()
                .navigateToFormsSection()
                .navigateToPracticeForm()
                .fillPracticeForm("Alice", "Smith", "alice@test.com", "1234567890");
        
        formsPage.submitForm();
        // Add assertions for successful submission
    }

    @Test
    public void testPageNavigation() {
        DemoQaHomePage homePage = new DemoQaHomePage().navigateToDemoQaPage();
        
        // Verify Elements page loaded with page identifier and timeout
        assertTrue(homePage.navigateToElementsSection()
            .verifyPageLoaded(By.xpath("//div[@class='element-list collapse show']//parent::div//div[@class='header-text' and text() = 'Elements']"), Constants.DEFAULT_TIMEOUT));

        homePage.navigateToHomePage();
        // Verify Forms page loaded
        assertTrue(homePage.navigateToFormsSection()
            .verifyPageLoaded(By.xpath("//div[@class='element-list collapse show']//parent::div//div[@class='header-text' and text() = 'Forms']"), Constants.DEFAULT_TIMEOUT));
    }
    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
