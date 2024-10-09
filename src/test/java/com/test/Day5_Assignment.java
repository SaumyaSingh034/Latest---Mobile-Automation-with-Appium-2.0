package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.UseAbleMethods;

import java.time.Duration;
import java.util.Collections;

public class Day5_Assignment extends BaseTest{

    @Test
    public void Scenario1_ScrollAndSwipe() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='standard_user']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN"))).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Test.allTheThings() T-Shirt (Red)\"));")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-ADD TO CART"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"))).click();
        UseAbleMethods.swipeLeftOnProduct("//android.widget.TextView[@text='Test.allTheThings() T-Shirt (Red)']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"REMOVE\"]"))).click();

    }

    @Test
    public void Scenario2_DragAndDrop(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='standard_user']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN"))).click();
        WebElement sourceElement = driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup"));
        UseAbleMethods.waitForElementToBeVisible(sourceElement);

        WebElement targetElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"));
        UseAbleMethods.waitForElementToBeVisible(targetElement);

        UseAbleMethods.performDragAndDrop(sourceElement,targetElement);
    }

    @Test
    public void Scenario3_ZoomAndPinch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='standard_user']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]"))).click();
        UseAbleMethods.zoomOnImage(driver.findElements(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView\n")).get(0));

    }
  }
