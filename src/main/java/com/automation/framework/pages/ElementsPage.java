package com.automation.framework.pages;

import org.openqa.selenium.By;

public class ElementsPage extends BasePage {
    private final By textBoxMenu = By.xpath("//span[text()='Text Box']");
    private final By checkBoxMenu = By.xpath("//span[text()='Check Box']");
    private final By radioButtonMenu = By.xpath("//span[text()='Radio Button']");
    
    public ElementsPage navigateToTextBox() {
        clickElement(textBoxMenu);
        return this;
    }
    
    public ElementsPage fillTextBoxForm(String fullName, String email, String currentAddress, String permanentAddress) {
        enterText(By.id("userName"), fullName);
        enterText(By.id("userEmail"), email);
        enterText(By.id("currentAddress"), currentAddress);
        enterText(By.id("permanentAddress"), permanentAddress);
        clickElement(By.id("submit"));
        return this;
    }
    
    public String getOutputText() {
        return driver.findElement(By.id("output")).getText();
    }
}
