package utilities;

import com.google.common.collect.ImmutableMap;
import com.test.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UseAbleMethods extends BaseTest {

    public static void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public  static void swipeLeftOnProduct(String productLocator) {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(productLocator)));
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75));
    }

    public static void performDragAndDrop(String sourceElement) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath(sourceElement)));
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 503,
                "endY", 318));

    }

    public static void zoomOnImage(String imageElement) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath(imageElement)));
        ((JavascriptExecutor) driver).executeScript("mobile: pinchOpen", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "scale", 2.0,  // Zoom in by 2x
                "velocity", 1.0 // Speed of the gesture
        ));
    }

    public static void zoomInOnElement(AndroidDriver driver, WebElement element) {
        // Get the center of the element
        int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        // Finger 1 starts just above the center
        TouchAction finger1 = new TouchAction(driver)
                .press(PointOption.point(centerX, centerY - 50))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(centerX, centerY - 200))  // Move up
                .release();

        // Finger 2 starts just below the center
        TouchAction finger2 = new TouchAction(driver)
                .press(PointOption.point(centerX, centerY + 50))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(centerX, centerY + 200))  // Move down
                .release();

        // Perform both actions simultaneously
        new MultiTouchAction(driver)
                .add(finger1)
                .add(finger2)
                .perform();
    }
    public static void pinchOnImage(WebElement imageElement) {
        // Get the location and size of the image element
        int centerX = imageElement.getLocation().getX() + (imageElement.getSize().getWidth() / 2);
        int centerY = imageElement.getLocation().getY() + (imageElement.getSize().getHeight() / 2);
        int startOffset = 200;  // Adjust this to control pinch distance

        // First finger gesture: start far from the center and move towards the center (pinch in)
        TouchAction finger1 = new TouchAction(driver)
                .press(PointOption.point(centerX, centerY - startOffset))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(centerX, centerY - 100))
                .release();

        // Second finger gesture: start far from the center and move towards the center (pinch in)
        TouchAction finger2 = new TouchAction(driver)
                .press(PointOption.point(centerX, centerY + startOffset))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(centerX, centerY + 100))
                .release();

        // Perform both gestures simultaneously using MultiTouchAction
        new MultiTouchAction(driver)
                .add(finger1)
                .add(finger2)
                .perform();
    }

}
