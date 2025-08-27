package com.automation.framework.listeners;

import com.automation.framework.drivermanager.DriverFactory;
import com.automation.framework.frameworkengine.SendMail;
import com.automation.framework.reporting.HtmlReporter;
import com.automation.framework.utils.PropertyReader;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("STARTING TEST: " + result.getName(), true);
        HtmlReporter.logTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("PASSED TEST: " + result.getName(), true);
        HtmlReporter.logTestSuccess(result);
        cleanupDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("FAILED TEST: " + result.getName(), true);

        WebDriver webDriver = DriverFactory.getWebDriver();
        AppiumDriver mobileDriver = DriverFactory.getMobileDriver();

        String screenshotPath = null;
        if (webDriver != null) {
            screenshotPath = captureScreenshot(webDriver, result.getName());
        } else if (mobileDriver != null) {
            screenshotPath = captureScreenshot(mobileDriver, result.getName());
        }

        HtmlReporter.logTestFailure(result, screenshotPath);
        cleanupDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("SKIPPED TEST: " + result.getName(), true);
        cleanupDriver();
    }

    @Override
    public void onFinish(ITestContext context) {
        HtmlReporter.finalizeReport();

        if ("true".equalsIgnoreCase(PropertyReader.getProperty("send.email"))) {
            SendMail.sendReportEmail();
        }
    }

    private void cleanupDriver() {
        DriverFactory.quitDriver();
    }

    private String captureScreenshot(WebDriver driver, String testName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotDir = "target/custom-report/screenshots";
            File dir = new File(screenshotDir);
            if (!dir.exists()) dir.mkdirs();

            String screenshotPath = screenshotDir + "/" + testName + "_" + timestamp + ".png";
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(screenshotPath));
            Reporter.log("Screenshot saved: " + screenshotPath, true);
            return "screenshots/" + testName + "_" + timestamp + ".png"; // relative path for HTML
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
