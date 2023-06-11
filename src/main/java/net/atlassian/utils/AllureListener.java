package net.atlassian.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import net.atlassian.driver.DriverManager;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result.getName());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] captureScreenshot(String screenshotName) {
        WebDriver driver = DriverManager.getDriver();
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        return screenshot.getScreenshotAs(OutputType.BYTES);
    }
}
