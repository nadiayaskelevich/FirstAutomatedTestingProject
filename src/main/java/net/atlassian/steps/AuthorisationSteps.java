package net.atlassian.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import net.atlassian.pages.LoginPage;
import net.atlassian.pages.LogoutPage;
import net.atlassian.pages.ProfileSubmenuPage;
import net.atlassian.utils.Waiters;
import org.openqa.selenium.WebDriver;

import java.util.ResourceBundle;

@Log4j2
public class AuthorisationSteps {

    private LoginPage loginPage;
    private ProfileSubmenuPage profileSubmenuPage;
    private LogoutPage logoutPage;
    static ResourceBundle bundle = ResourceBundle.getBundle("test");
    private final String USERNAME = bundle.getString("username");
    private final String PASSWORD = bundle.getString("password");

    public AuthorisationSteps (WebDriver driver) {
        loginPage = new LoginPage(driver);
        profileSubmenuPage = new ProfileSubmenuPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    public void enterEmail(String email) {
        Waiters.waitForVisibility(loginPage.getEmailField());
        loginPage.getEmailField().sendKeys(email);
    }

    public void clickContinueButton() {
        loginPage.getContinueButton().click();
    }

    public void enterPassword(String password) {
        Waiters.waitForVisibility(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(password);
    }

    public void clickLoginButton() {
        loginPage.getLoginButton().click();
    }

    public void clickProfileIcon() {
        profileSubmenuPage.getProfileIcon().click();
    }

    public void clickLogoutLink(){
        profileSubmenuPage.getLogoutLink().click();
    }

    public void submitLogout() {
        logoutPage.getLogoutSubmitButton().click();
    }

    @Step("Log in Atlassian account")
    public void login() {
        log.info("login");

        enterEmail(USERNAME);
        clickContinueButton();
        enterPassword(PASSWORD);
        clickLoginButton();
    }

    @Step("Log out of Atlassian account")
    public void logout() {
        log.info("logout");

        clickProfileIcon();
        clickLogoutLink();
        submitLogout();
    }

}
