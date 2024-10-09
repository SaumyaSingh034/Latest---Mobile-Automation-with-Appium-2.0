package com.test;

import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;
    public static WebDriverWait wait;

    @BeforeClass
    public void initWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @BeforeTest
    public void appiumSetUpTest(){

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js")) // Update with your path
                .withIPAddress("127.0.0.1")
                .usingPort(4725)
                .withTimeout(Duration.ofSeconds(60));

        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5558");
        options.setApp("/Users/saumya.singh/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        options.setLanguage("en");
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity(".MainActivity");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4725/"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void tearDown(){
        service.stop();  // Stops the Appium server
        System.out.println("Appium service stopped.");
    }
}
