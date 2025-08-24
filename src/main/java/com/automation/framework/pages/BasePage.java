package com.automation.framework.pages;

import com.automation.framework.drivermanager.DriverFactory;
import com.automation.framework.frameworkengine.PageActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    
    public BasePage() {
        this.driver = DriverFactory.getWebDriver();
    }
    
    protected void clickElement(By locator) {
        PageActionUtils.click(driver, locator);
    }
    
    protected void enterText(By locator, String text) {
        PageActionUtils.sendKeys(driver, locator, text);
    }
    
    public boolean verifyPageLoaded(By pageIdentifier, int timeout) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(pageIdentifier));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
