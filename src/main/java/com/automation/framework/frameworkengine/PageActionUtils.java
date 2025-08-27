package com.automation.framework.frameworkengine;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Centralized WebDriver actions with built-in waits and logging
 */
public class PageActionUtils {
    private static final int TIMEOUT = 30;
    
    public static void click(WebDriver driver, By locator) {
        WebElement element = waitForElementVisible(driver, locator);
        scrollToElement(driver, element);
        element.click();
    }

    public static void sendKeys(WebDriver driver, By locator, String text) {
        WebElement element = waitForElementVisible(driver, locator);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(WebDriver driver, By locator) {
        return waitForElementVisible(driver, locator).getText();
    }

    private static WebElement waitForElementVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -150);", element);
    }

}
