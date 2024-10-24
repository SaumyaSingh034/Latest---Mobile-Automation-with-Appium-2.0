package com.test;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Day3_Assignment extends BaseTest{

    @Test
    public void checkoutAnItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(standardUser))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(loginBtn))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup"))).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT\"]"))).click();
    }
}
