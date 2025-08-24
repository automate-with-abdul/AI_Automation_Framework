package com.automation.framework.pages;

import org.openqa.selenium.By;

public class FormsPage extends BasePage {
    private final By practiceFormMenu = By.xpath("//span[text()='Practice Form']");
    
    public FormsPage navigateToPracticeForm() {
        clickElement(practiceFormMenu);
        return this;
    }
    
    public FormsPage fillPracticeForm(String firstName, String lastName, String email, String mobile) {
        enterText(By.id("firstName"), firstName);
        enterText(By.id("lastName"), lastName);
        enterText(By.id("userEmail"), email);
        enterText(By.id("userNumber"), mobile);
        return this;
    }
    
    public void submitForm() {
        clickElement(By.id("submit"));
    }
}
