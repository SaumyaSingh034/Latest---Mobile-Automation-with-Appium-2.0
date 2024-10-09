package utilities;

import com.test.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MultiTouchAction;
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

import java.time.Duration;
import java.util.Collections;

public class UseAbleMethods extends BaseTest {

    public static void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public  static void swipeLeftOnProduct(String productLocator) {
        // Locate the product element on the screen
        WebElement product =  driver.findElement(AppiumBy.xpath(productLocator));

        // Get the location and size of the product element
        int startX = product.getLocation().getX() + product.getSize().getWidth() - 10; // start from near the right edge
        int endX = product.getLocation().getX() + 10; // swipe towards the left edge
        int startY = product.getLocation().getY() + (product.getSize().getHeight() / 2); // middle of the element in height

        // Perform the swipe gesture
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // wait for half a second
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
    }

    public static void performDragAndDrop(WebElement sourceElement, WebElement targetElement) {
        try {
            Point sourceElem = sourceElement.getLocation();
            Point targetElem = targetElement.getLocation();

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence dragAndDrop = new Sequence(finger, 1);
            dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
                    sourceElem.x, sourceElem.y));
            dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(),
                    targetElem.x, targetElem.y));
            dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(dragAndDrop));
        } catch (NoSuchElementException ex) {
            System.out.println("Exception Message: " + ex.getMessage());
        }

    }

    public static void zoomOnImage(WebElement imageElement) {
        // Get the location and size of the image element
        int centerX = imageElement.getLocation().getX() + (imageElement.getSize().getWidth() / 2);
        int centerY = imageElement.getLocation().getY() + (imageElement.getSize().getHeight() / 2);
        int startOffset = 100;  // Adjust this to control zoom distance

        // First finger gesture: start near the center and move upwards (zoom out)
        TouchAction finger1 = new TouchAction(driver)
                .press(PointOption.point(centerX, centerY - startOffset))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(centerX, centerY - (startOffset + 200)))
                .release();

        // Second finger gesture: start near the center and move downwards (zoom in)
        TouchAction finger2 = new TouchAction(driver)
                .press(PointOption.point(centerX, centerY + startOffset))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(centerX, centerY + (startOffset + 200)))
                .release();

        // Perform both gestures simultaneously using MultiTouchAction
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
