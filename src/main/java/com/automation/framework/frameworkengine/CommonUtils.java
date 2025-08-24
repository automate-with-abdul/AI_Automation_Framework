package com.automation.framework.frameworkengine;

import java.util.Random;

/**
 * Common utility methods for test automation
 */
public class CommonUtils {
    
    public static String generateRandomEmail() {
        return "user" + System.currentTimeMillis() + "@test.com";
    }

    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
