package com.automation.framework.listeners;

import com.automation.framework.drivermanager.DriverFactory;
import com.automation.framework.frameworkengine.SendMail;
import com.automation.framework.utils.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final String LINE = "\n----------------------------------------\n";

    @Override
    public void onTestStart(ITestResult result) {
        logMessage("STARTING TEST: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logMessage("PASSED TEST: " + result.getName());
        if (PropertyReader.getProperty("send.email").equalsIgnoreCase("true")) {
            SendMail.sendReportEmail();
        }
        // Ensure driver cleanup
        DriverFactory.quitDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logMessage("FAILED TEST: " + result.getName());
        
        // Capture screenshot for both Web and Mobile drivers
        WebDriver webDriver = DriverFactory.getWebDriver();
        AppiumDriver mobileDriver = DriverFactory.getMobileDriver();
        
        if (webDriver != null) {
            captureScreenshot(webDriver);
        } else if (mobileDriver != null) {
            captureScreenshot(mobileDriver);
        }
        
        if (PropertyReader.getProperty("send.email").equalsIgnoreCase("true")) {
            SendMail.sendReportEmail();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment
    private String logMessage(String message) {
        return LINE + message + LINE;
    }
}
