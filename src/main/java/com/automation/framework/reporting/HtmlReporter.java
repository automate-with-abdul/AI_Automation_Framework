package com.automation.framework.reporting;

import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HtmlReporter {

    private static final String REPORT_PATH = "target/custom-report";
    private static final String REPORT_FILE = REPORT_PATH + "/index.html";
    private static BufferedWriter writer;

    static {
        try {
            File dir = new File(REPORT_PATH);
            if (!dir.exists()) dir.mkdirs();

            writer = new BufferedWriter(new FileWriter(REPORT_FILE));
            writer.write("<html><head><title>Automation Report</title></head><body>");
            writer.write("<h1>Test Execution Report</h1>");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logTestStart(ITestResult result) {
        try {
            writer.write("<h3>Test Started: " + result.getName() + "</h3>");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logTestSuccess(ITestResult result) {
        try {
            writer.write("<p style='color:green;'>PASSED: " + result.getName() + "</p>");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logTestFailure(ITestResult result, String screenshotPath) {
        try {
            writer.write("<p style='color:red;'>FAILED: " + result.getName() + "</p>");
            if (screenshotPath != null) {
                writer.write("<img src='" + screenshotPath + "' width='400'/>");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void finalizeReport() {
        try {
            writer.write("</body></html>");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
