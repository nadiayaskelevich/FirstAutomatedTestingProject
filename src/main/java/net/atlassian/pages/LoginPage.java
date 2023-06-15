package net.atlassian.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
    }

    @FindBy(id = "username")
    private WebElement emailField;

    @FindBy(id = "login-submit")
    private WebElement continueButton;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement loginButton;

}
