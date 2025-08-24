package com.automation.framework.tests.mobile;

import com.automation.framework.drivermanager.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTests {
    AppiumDriver driver;
    
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initializeMobileDriver(
                "Android",
                "emulator-5554",
                "/path/to/app.apk",
                "http://localhost:4723/wd/hub"
        );
    }

    @Test
    public void testAppLaunch() {
        // Add mobile test logic here
        // Example: Verify home screen elements
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
