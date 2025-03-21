import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;


public class Base  {

    public AndroidDriver driver;
   // public AppiumDriverLocalService service;



    @BeforeSuite
    public void Configure() throws URISyntaxException, IOException {

       // service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\mataga\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib")).
               // withIPAddress("127.0.0.1").usingPort(4723).build();
       // service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Ren staging");
        options.setUdid("060403711F002063");
        options.setAutomationName("UiAutomator2");
        options.setAppActivity("com.renmoney.android/.MainActivity");
        options.setAppPackage("com.renmoney.android");
       // options.setApp("C:\\Users\\mataga\\IdeaProjects\\renmobile\\src\\test\\resources\\app-debug.apk");
        options.setNoReset(false);
        options.setAutoGrantPermissions(true);

        driver = new AndroidDriver(new URI("http://localhost:4723").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //usernamePage username = new usernamePage(driver);

    }

    @AfterSuite
    public void tearDown(){

        driver.terminateApp("com.renmoney.android");
        driver.quit();
       // service.stop();
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
    }


}
