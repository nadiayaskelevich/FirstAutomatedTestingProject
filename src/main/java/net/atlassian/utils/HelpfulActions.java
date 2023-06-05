package net.atlassian.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class HelpfulActions {
    public static void pressEscapeKey(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
