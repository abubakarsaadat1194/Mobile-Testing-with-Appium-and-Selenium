package mobile_testing_app;

import mobile_testing_app.MobileTesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.*;

import java.time.Duration;
import java.util.List;

public class Assignment {

private static String[] loginPageElements = {
        "com.experitest.ExperiBank:id/usernameTextField",
        "com.experitest.ExperiBank:id/passwordTextField",
        "com.experitest.ExperiBank:id/loginButton"
};

private static String[] summaryPageElements = {
        "com.experitest.ExperiBank:id/makePaymentButton",
        "com.experitest.ExperiBank:id/logoutButton"
};

private static String[] paymentPageElements = {
        "com.experitest.ExperiBank:id/phoneTextField",
        "com.experitest.ExperiBank:id/nameTextField",
        "com.experitest.ExperiBank:id/nameTextField",
        "com.experitest.ExperiBank:id/amountLabel",
        "com.experitest.ExperiBank:id/amount",
        "com.experitest.ExperiBank:id/countryTextField",
        "com.experitest.ExperiBank:id/countryButton",
        "com.experitest.ExperiBank:id/sendPaymentButton",
        "com.experitest.ExperiBank:id/cancelButton"
};

public static void run() throws NoSuchElementException {

    AndroidDriver<AndroidElement> driver =
            (AndroidDriver<AndroidElement>) MobileTesting.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, 15);
    AndroidElement element;
    Actions action = new Actions(driver);
    Alert alert;

    // (1) Check login page
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginPageElements[0])));
    MobileTesting.printTest(1);

    // (2) Type username
    driver.findElement(By.id(loginPageElements[0])).sendKeys("company");
    MobileTesting.printTest(2);

    // (3) Focus password
    driver.findElement(By.id(loginPageElements[1])).click();
    MobileTesting.printTest(3);

    // (4) Type password
    driver.findElement(By.id(loginPageElements[1])).sendKeys("company");
    MobileTesting.printTest(4);

    // (5) Focus username
    driver.findElement(By.id(loginPageElements[0])).click();
    MobileTesting.printTest(5);

    // (6) Clear username
    driver.findElement(By.id(loginPageElements[0])).clear();
    MobileTesting.printTest(6);

    // (7) Login attempt (should fail)
    driver.findElement(By.id(loginPageElements[2])).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginPageElements[0])));
    MobileTesting.printTest(7);

    // (8) Re-enter username
    driver.findElement(By.id(loginPageElements[0])).sendKeys("company");
    driver.findElement(By.id(loginPageElements[1])).clear();
    driver.findElement(By.id(loginPageElements[1])).sendKeys("company");
    MobileTesting.printTest(8);

    // (9) Login success
    driver.findElement(By.id(loginPageElements[2])).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(summaryPageElements[0])));
    MobileTesting.printTest(9);

    // (10) Go to payment page
    driver.findElement(By.id(summaryPageElements[0])).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paymentPageElements[0])));
    MobileTesting.printTest(10);

    // (11) Enter phone
    driver.findElement(By.id(paymentPageElements[0])).sendKeys("612-555-0112");
    MobileTesting.printTest(11);

    // (12) Enter name
    driver.findElement(By.id(paymentPageElements[1])).sendKeys("Alice");
    MobileTesting.printTest(12);

    // (13) Move slider
    AndroidElement slider = driver.findElement(By.id(paymentPageElements[4]));
    action.clickAndHold(slider).moveByOffset(150,0).release().perform();
    MobileTesting.printTest(13);

    // (14) Send payment (missing country so stay on page)
    driver.findElement(By.id(paymentPageElements[7])).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paymentPageElements[0])));
    MobileTesting.printTest(14);

    // (15) Enter country manually
    driver.findElement(By.id(paymentPageElements[5])).sendKeys("United States");
    MobileTesting.printTest(15);

    // (16) Cancel payment
    driver.findElement(By.id(paymentPageElements[8])).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(summaryPageElements[0])));
    MobileTesting.printTest(16);

    // (17) Open payment again
    driver.findElement(By.id(summaryPageElements[0])).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paymentPageElements[0])));
    MobileTesting.printTest(17);

    // (18) Enter phone
    driver.findElement(By.id(paymentPageElements[0])).sendKeys("612-555-0355");
    MobileTesting.printTest(18);

    // (19) Enter name
    driver.findElement(By.id(paymentPageElements[1])).sendKeys("Bob");
    MobileTesting.printTest(19);

    // (20) Move slider again
    slider = driver.findElement(By.id(paymentPageElements[4]));
    action.clickAndHold(slider).moveByOffset(200,0).release().perform();
    MobileTesting.printTest(20);

    // (21) Open country list
    driver.findElement(By.id(paymentPageElements[6])).click();
    MobileTesting.printTest(21);

    // (22) Select France
    driver.findElement(By.xpath("//android.widget.TextView[@text='USA']")).click();
    MobileTesting.printTest(22);
    MobileTesting.printTest(22);

 // (23) Send payment
    driver.findElement(By.id(paymentPageElements[7])).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
    MobileTesting.printTest(23);

    // (24) Press No
    driver.findElement(By.id("android:id/button2")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paymentPageElements[0])));
    MobileTesting.printTest(24);

    // (25) Send payment again
    driver.findElement(By.id(paymentPageElements[7])).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
    MobileTesting.printTest(25);

    // (26) Press Yes
    driver.findElement(By.id("android:id/button1")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(summaryPageElements[0])));
    MobileTesting.printTest(26);
    
    // (27) Logout
    driver.findElement(By.id(summaryPageElements[1])).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginPageElements[0])));
    MobileTesting.printTest(27);
}
}


