package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class LoginPage {
    public AndroidDriver driver;
    public WebDriverWait wait;
    // Constructor to initialize PageFactory and elements
    public LoginPage(AndroidDriver driver, WebDriverWait wait) {

       this.driver = driver;
       this.wait = wait;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='locked_out_user']")
    private WebElement logOutUser;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement login;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]")
    private WebElement lockedMessage;

    public void openLoginPage() {
        tap(login);
        waitForElementIsVisible(login);
    }

    public String locked_out_user(){
        tap(logOutUser);
        tap(login);
       return getTextFromWebElement(lockedMessage);

    }

    public String getTextFromWebElement(WebElement element){  try {
        waitForElementIsVisible(element);
       return element.getText();
    } catch (Exception ex) {
        System.out.println("Exception Message: " + ex.getMessage());
    }
        return null;
    }

  /*  public void performLogin(String username, String password) {
        setValue(txtEmail, username);
        setValue(txtPassword, password);
        tap(btnSubmit);
    }*/



    public void tap(WebElement element) {
        try {
            waitForElementIsVisible(element);
            element.click();
        } catch (Exception ex) {
            System.out.println("Exception Message: " + ex.getMessage());
        }
    }

    public void setValue(WebElement element, String value) {
        try {
            waitForElementIsVisible(element);
            element.sendKeys(value);
        } catch (Exception ex) {
            System.out.println("Exception Message: " + ex.getMessage());
        }
    }

    public void waitForElementIsVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException ex) {
            System.out.println("Exception Message: " + ex.getMessage());
        }
    }

    public void performDragAndDrop(WebElement sourceElement, WebElement targetElement) {
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






}