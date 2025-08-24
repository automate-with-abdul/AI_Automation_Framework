package com.automation.framework.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Collections;
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
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        
        // Move to starting position
        swipe.addAction(finger.createPointerMove(Duration.ZERO, 
            PointerInput.Origin.viewport(), 0, startY));
        
        // Press down
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        
        // Move to end position
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500),
            PointerInput.Origin.viewport(), 0, endY));
            
        // Release
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        // Perform the sequence
        driver.perform(Collections.singletonList(swipe));
    }

    private static WebElement waitForElementVisible(AppiumDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(MOBILE_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
