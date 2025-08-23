package com.automation.framework.tests;

import com.automation.framework.core.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTests extends BaseTest {
    
    @Test
    public void testExamplePageTitle() {
        driver.get("https://example.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Example Domain"));
    }
}
