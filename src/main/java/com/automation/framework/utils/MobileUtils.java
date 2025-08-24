package com.automation.framework.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Map;

/**
 * Mobile-specific utility methods
 */
public class MobileUtils {
    private static final int MOBILE_TIMEOUT = 30;

    public static void tapElement(AppiumDriver driver, WebElement element) {
        waitForElementVisible(driver, element).click();
    }

    public static void swipeVertical(AppiumDriver driver, int startY, int endY) {
        new org.openqa.selenium.interactions.PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger")
            .createPointerMove(Duration.ofMillis(0), org.openqa.selenium.interactions.PointerInput.Origin.viewport(), startY, 0)
            .createPointerDown(org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT.asArg())
            .createPointerMove(Duration.ofMillis(500), org.openqa.selenium.interactions.PointerInput.Origin.viewport(), endY, 0)
            .createPointerUp(org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT.asArg());
    }

    private static WebElement waitForElementVisible(AppiumDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(MOBILE_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
