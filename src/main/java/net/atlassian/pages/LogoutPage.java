package net.atlassian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    public LogoutPage(WebDriver driver) {
    }

    @FindBy(id = "logout-submit")
    private WebElement logoutSubmitButton;

    public void submitLogout() {
        logoutSubmitButton.click();
    }

}
