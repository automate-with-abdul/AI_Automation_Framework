package com.automation.framework.listeners;

import com.automation.framework.drivermanager.DriverFactory;
import com.automation.framework.frameworkengine.SendMail;
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
        SendMail.sendReportEmail();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logMessage("FAILED TEST: " + result.getName());
        captureScreenshot(DriverFactory.getWebDriver());
        SendMail.sendReportEmail();
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
