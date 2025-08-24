package com.automation.framework.tests.demoqa;

import com.automation.framework.frameworkengine.Constants;
import com.automation.framework.pages.DemoQaHomePage;
import com.automation.framework.pages.ElementsPage;
import com.automation.framework.pages.FormsPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DemoQaTests {
    
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testElementsPageTextBox() {
        ElementsPage elementsPage = new DemoQaHomePage()
                .navigateToHomePage()
                .navigateToElementsSection()
                .navigateToTextBox()
                .fillTextBoxForm("John Doe", "john@test.com", "123 Main St", "456 Second St");
        
        String output = elementsPage.getOutputText();
        assertTrue(output.contains("John Doe"));
        assertTrue(output.contains("john@test.com"));
    }

    @Test
    public void testPracticeFormSubmission() {
        FormsPage formsPage = new DemoQaHomePage()
                .navigateToHomePage()
                .navigateToFormsSection()
                .navigateToPracticeForm()
                .fillPracticeForm("Alice", "Smith", "alice@test.com", "1234567890");
        
        formsPage.submitForm();
        // Add assertions for successful submission
    }

    @Test
    public void testPageNavigation() {
        DemoQaHomePage homePage = new DemoQaHomePage().navigateToHomePage();
        
        // Verify Elements page loaded with page identifier and timeout
        assertTrue(homePage.navigateToElementsSection()
            .verifyPageLoaded(By.xpath("//div[@class='main-header' and text()='Elements']"), Constants.DEFAULT_TIMEOUT));
        
        // Verify Forms page loaded
        assertTrue(homePage.navigateToFormsSection()
            .verifyPageLoaded(By.xpath("//div[@class='main-header' and text()='Forms']"), Constants.DEFAULT_TIMEOUT));
    }
}
