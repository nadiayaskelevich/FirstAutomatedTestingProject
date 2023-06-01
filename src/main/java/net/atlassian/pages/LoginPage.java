package net.atlassian.pages;

import net.atlassian.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

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

    public void enterEmail(String email) {
        Waiters.waitForVisibility(emailField);
        emailField.sendKeys(email);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void enterPassword(String password) {
        Waiters.waitForVisibility(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
