package org.renmoney;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Base  {

    public AndroidDriver driver;
    //public WebDriverWait wait;
    public AppiumDriverLocalService service;



    @BeforeSuite
    public void Configure() throws URISyntaxException, IOException {

        /*service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\mataga\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib")).
               withIPAddress("127.0.0.1").usingPort(4723).build();
       service.start();

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1").usingPort(4723);
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();
        driver = new AndroidDriver(service.getUrl(), options);*/

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Ren staging");
        options.setUdid("060403711F002063");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.renmoney.android");
        options.setAppActivity("com.renmoney.android/.MainActivity");
        options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(60000));
       // options.setApp("C:\\Users\\mataga\\IdeaProjects\\renmobile\\src\\test\\resources\\app-debug.apk");
        options.setNoReset(false);
        options.setAutoGrantPermissions(true);

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



    }

    @AfterSuite
    public void tearDown(){

        driver.terminateApp("com.renmoney.android");
        driver.quit();
       // service.stop();
    }




    public static void scrollByBounds(AndroidDriver driver, int startX, int startY, int endX, int endY) {
        System.out.println("🔄 Scrolling from [" + startX + "," + startY + "] to [" + endX + "," + endY + "]");

        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        System.out.println("📱 Screen size: Width=" + screenWidth + ", Height=" + screenHeight);

        // Ensure the coordinates are within screen bounds
        if (startX < 0 || startY < 0 || endX > screenWidth || endY > screenHeight) {
            System.out.println("❌ Invalid coordinates! Adjusting...");
            startX = Math.max(0, Math.min(startX, screenWidth - 1));
            startY = Math.max(0, Math.min(startY, screenHeight - 1));
            endX = Math.max(0, Math.min(endX, screenWidth - 1));
            endY = Math.max(0, Math.min(endY, screenHeight - 1));
        }

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));

        System.out.println("✅ Scrolling complete!");
    }





    public void clickCloseButton() {
        try {
            // Using XPath (Recommended)
            WebElement closeButton = driver.findElement(By.xpath("//android.widget.Button[@clickable='true']"));
            closeButton.click();
        } catch (Exception e) {
            System.out.println("Close button not found via XPath, trying coordinate tap...");

            // Fallback: Tap on coordinates
            int x = (572 + 668) / 2;
            int y = (114 + 210) / 2;
            TouchAction action = new TouchAction(driver);
            action.tap(PointOption.point(x, y)).perform();
        }




    }

    public static void swipev(AndroidDriver driver) {
        // Get screen size
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        // Calculate swipe start and end points
        int startX = width / 2;      // Middle of the screen (X-axis)
        int startY = (int) (height * 0.9);  // Near bottom (Y-axis)
        int endY = (int) (height * 0.3);    // Near top (Y-axis)

        // Create touch input
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        // Move to start position
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        // Press down
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        // Move to end position (swipe action)
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), startX, endY));
        // Release touch
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the swipe
        driver.perform(Arrays.asList(swipe));
    }






    public void swipeUntilElementVisible(AndroidDriver driver,String elementText) {
        int maxSwipes = 3; // Avoid infinite loop
        int swipeCount = 0;

        while (swipeCount < maxSwipes) {
            maxSwipes = 3; // Avoid infinite loop
            swipeCount = 0;
            Dimension size = driver.manage().window().getSize();
            int startX = size.width / 2;
            int startY = (int) (size.height * 0.7); // Start near the bottom
            int endY = (int) (size.height * 0.3); // Scroll upwards// Swipe up towards the top

            while (swipeCount < maxSwipes) {
                try {

                    WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"" + elementText + "\")"));

                    if (element.isDisplayed()) {
                        element.click();
                        break; // Stop scrolling when the element is visible
                    }
                } catch (NoSuchElementException e) {
                    swipe(driver, startX, startY, startX, endY);
                }
                swipeCount++;
            }
        }
    }
    public void swipe(AndroidDriver driver, int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(900), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }



    public void WaitForOffer(AndroidDriver driver){
        FluentWait<AndroidDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMinutes(4))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(java.util.NoSuchElementException.class);
        WebElement offerElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Select an offer")));
        System.out.println("Offer displayed");
    }
}
