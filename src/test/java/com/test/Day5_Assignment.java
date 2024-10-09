package com.test;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.UseAbleMethods;


public class Day5_Assignment extends BaseTest{

    @Test
    public void Scenario1_ScrollAndSwipe() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='standard_user']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN"))).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Test.allTheThings() T-Shirt (Red)\"));")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-ADD TO CART"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"))).click();
        UseAbleMethods.swipeLeftOnProduct("test-Item");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Delete\"]/android.view.ViewGroup"))).click();


    }

    @Test
    public void Scenario2_DragAndDrop(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='standard_user']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN"))).click();
        UseAbleMethods.performDragAndDrop("(//android.view.ViewGroup[@content-desc='test-Drag Handle'])[1]");
    }

    @Test
    public void Scenario3_ZoomAndPinch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='standard_user']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]"))).click();
        UseAbleMethods.zoomOnImage("//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView\n");
       // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView")));
        //UseAbleMethods.zoomInOnElement(driver, element);

    }
  }
