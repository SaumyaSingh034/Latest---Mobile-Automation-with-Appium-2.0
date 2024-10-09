package com.test;

import Pages.LoginPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day4_Assignment extends BaseTest{

    public LoginPage lp = new LoginPage(driver, wait);

    @Test
    public void Scenario1_LockedOutUser(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='locked_out_user']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN"))).click();
       String actualLoginText =  wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]"))).getText();
       Assert.assertEquals(actualLoginText,"Sorry, this user has been locked out.");
    }
    @Test
    public void Scenario2_applyFilters()  {

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='standard_user']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Modal Selector Button']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Name (Z to A)']"))).click();
        String status = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@content-desc='test-Item title' and @text='Test.allTheThings() T-Shirt (Red)']"))).getText();
        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", status);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGOUT"))).click();

    }

    @Test
    public void Scenario3_AddItemToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='standard_user']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN"))).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])[1]"))).click();wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup"))).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-First Name"))).sendKeys("AutomationTest");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-Last Name"))).sendKeys("Appium"+Math.random());
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-Zip/Postal Code"))).sendKeys("110077");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUE\"]"))).click();
        String actualOrderDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]"))).getText();
        Assert.assertEquals(actualOrderDetails,"Sauce Labs Backpack");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-FINISH"))).click();
        String orderComplete = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]"))).getText();
        Assert.assertEquals(orderComplete,"CHECKOUT: COMPLETE!");
        String ThankYouForOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]"))).getText();
       Assert.assertEquals(ThankYouForOrder,"THANK YOU FOR YOU ORDER");
    }

    @Test
    public void Scenario4_RemoveItemFromCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='standard_user']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])[1]"))).click();
        String expectedText = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='1']"))).getText();
        System.out.println(expectedText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"REMOVE\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"LOGOUT\"]"))).click();



    }





}
