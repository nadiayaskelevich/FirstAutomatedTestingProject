package net.atlassian.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LogoutPage extends BasePage {

    public LogoutPage(WebDriver driver) {
    }

    @FindBy(id = "logout-submit")
    private WebElement logoutSubmitButton;

}
