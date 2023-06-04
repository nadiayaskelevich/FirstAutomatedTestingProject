package net.atlassian.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HelpfulActions {
    public static void pressEscapeKey(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }
}
