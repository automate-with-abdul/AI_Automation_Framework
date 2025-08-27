package com.automation.framework.pages;

import org.openqa.selenium.By;

public class DemoQaHomePage extends BasePage {
    // Section locators
    private final By elementsSection = By.xpath("//h5[text()='Elements']");
    private final By formsSection = By.xpath("//h5[text()='Forms']");
    private final By homeButton = By.xpath("//header//a");
    private final By alertsSection = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    private final By widgetsSection = By.xpath("//h5[text()='Widgets']");
    private final By interactionsSection = By.xpath("//h5[text()='Interactions']");
    private final By bookStoreSection = By.xpath("//h5[text()='Book Store Application']");

    public DemoQaHomePage navigateToDemoQaPage() {
        driver.get("https://demoqa.com");
        return this;
    }

    public DemoQaHomePage navigateToHomePage() {
        clickElement(homeButton);
        return this;
    }

    public ElementsPage navigateToElementsSection() {
        clickElement(elementsSection);
        return new ElementsPage();
    }

    public FormsPage navigateToFormsSection() {
        clickElement(formsSection);
        return new FormsPage();
    }

}
