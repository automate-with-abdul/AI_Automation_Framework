package com.automation.framework.drivermanager;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

/**
 * Factory class for creating WebDriver and AppiumDriver instances
 */
public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();

    private DriverFactory() {} // Prevent instantiation

    /**
     * Initializes WebDriver based on browser type
     * @param browser Name of browser (chrome, firefox, edge)
     * @return WebDriver instance
     */
    public static WebDriver initializeWebDriver(String browser) {
        WebDriver driver;
        
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        webDriver.set(driver);
        return driver;
    }

    /**
     * Initializes AppiumDriver for mobile testing
     * @param platformName Mobile platform (Android/iOS)
     * @param deviceName Device name/UDID
     * @param appPath Path to mobile app
     * @param appiumServerURL Appium server URL
     * @return AppiumDriver instance
     */
    public static AppiumDriver initializeMobileDriver(String platformName, String deviceName, String appPath, String appiumServerURL) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", platformName);
            caps.setCapability("deviceName", deviceName);
            caps.setCapability("app", appPath);
            
            AppiumDriver driver = new AppiumDriver(new URL(appiumServerURL), caps);
            appiumDriver.set(driver);
            return driver;
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Appium driver", e);
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static AppiumDriver getMobileDriver() {
        return appiumDriver.get();
    }

    public static void quitDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
        if (appiumDriver.get() != null) {
            appiumDriver.get().quit();
            appiumDriver.remove();
        }
    }
}
