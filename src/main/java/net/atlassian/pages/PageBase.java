package net.atlassian.pages;

import net.atlassian.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    public PageBase() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}
