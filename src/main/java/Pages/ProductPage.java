package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private AndroidDriver driver;

    // Locators
    private WebElement filterButton;
    private WebElement filterOption;
    private WebElement gridViewButton;
    private WebElement listViewButton;

    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        initElements();
    }

    private void initElements() {
        filterButton = driver.findElement(AppiumBy.accessibilityId("test-Filter"));
        filterOption = driver.findElement(AppiumBy.accessibilityId("test-Filter-Option")); // Modify this according to the actual filter option ID
        gridViewButton = driver.findElement(AppiumBy.accessibilityId("test-Grid-View"));
        listViewButton = driver.findElement(AppiumBy.accessibilityId("test-List-View"));
    }

    public void applyFilter() {
        filterButton.click();
        filterOption.click();
        // Add validation logic if needed
    }

    public void switchToGridView() {
        gridViewButton.click();
        // Add validation logic if needed
    }

    public void switchToListView() {
        listViewButton.click();
        // Add validation logic if needed
    }
}