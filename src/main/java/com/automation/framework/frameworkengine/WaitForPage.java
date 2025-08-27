package com.automation.framework.frameworkengine;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Utility class for page load and element visibility waits
 */
public class WaitForPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitForPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMEOUT));
    }

    public void waitForPageTitle(String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitForUrlContains(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }

    public void waitForPageLoadComplete() {
        wait.until(driver -> {
            String state = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
            return state.equals("complete");
        });
    }
}
