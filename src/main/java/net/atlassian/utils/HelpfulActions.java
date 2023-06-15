package net.atlassian.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class HelpfulActions {

    public static void pressEscapeKey(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void switchToNewTab(WebDriver driver) {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND + "t");

        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            driver.switchTo().window(handle);
        }
    }

    public static void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

}
