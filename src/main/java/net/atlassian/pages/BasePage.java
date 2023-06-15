package net.atlassian.pages;

import net.atlassian.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
