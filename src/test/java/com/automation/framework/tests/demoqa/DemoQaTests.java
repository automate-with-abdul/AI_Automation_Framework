package com.automation.framework.tests.demoqa;

import com.automation.framework.pages.DemoQaHomePage;
import com.automation.framework.pages.ElementsPage;
import com.automation.framework.pages.FormsPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DemoQaTests {
    
    @Test
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
        
        assertTrue(homePage.navigateToElementsSection().verifyPageLoaded());
        assertTrue(homePage.navigateToFormsSection().verifyPageLoaded());
    }
}
