package com.automation.framework.tests.ui;

import com.automation.framework.drivermanager.DriverFactory;
import com.automation.framework.utils.SelfHealingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;
    
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initializeWebDriver("chrome");
        driver.get("https://example.com/login");
    }

    @Test
    public void testSuccessfulLogin() {
        By usernameLocator = By.id("username");
        By passwordLocator = By.name("password");
        By submitButton = By.xpath("//button[@type='submit']");
        
        // Using self-healing locator with CSS fallback
        SelfHealingUtils.findElement(driver, usernameLocator, 
                By.cssSelector("input[data-test='username']"))
                .sendKeys("testuser");
                
        SelfHealingUtils.findElement(driver, passwordLocator, 
                By.cssSelector("input[data-test='password']"))
                .sendKeys("pass123");
                
        SelfHealingUtils.findElement(driver, submitButton, 
                By.cssSelector("button.login-btn"))
                .click();
        
        // Add assertions
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
