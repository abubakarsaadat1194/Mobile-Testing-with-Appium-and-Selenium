package mobile_testing_app;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Main {

    public static void main(String[] args) throws Exception {

        // Path to APK
        Path currentRelativePath = Paths.get("");
        String eribankApp = Paths.get(
                currentRelativePath.toAbsolutePath().toString(),
                "app/EriBank.apk").toString();

        // Output file
        String outputPath = Paths.get(
                currentRelativePath.toAbsolutePath().toString(),
                "results/OutputFile.txt").toString();

        File output = new File(outputPath);
        output.delete();
        output.createNewFile();

        // Desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", eribankApp);

        capabilities.setCapability("adbExecTimeout", 60000);
        capabilities.setCapability("uiautomator2ServerLaunchTimeout", 120000);
        capabilities.setCapability("newCommandTimeout", 60000);

        // Appium server
        String appiumPath = "http://127.0.0.1:4723/wd/hub";
        Thread.sleep(5000);

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<>(new URL(appiumPath), capabilities);

        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Handle update popup if present
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.id("android:id/button1"))).click();
        } catch (TimeoutException e) {
            System.out.println("No update popup.");
        }

        // Wait for login page
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.experitest.ExperiBank:id/usernameTextField")));

        System.out.println("Initial page loaded successfully.");

        // Initialize testing
        MobileTesting.init(driver, output);

        try {
            Assignment.run();
        } catch (Exception e) {
            MobileTesting.printTest(-1);
            System.err.println(e);
        }

        driver.quit();
    }
}