package net.atlassian.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProfileSubmenuPage extends BasePage {
    public ProfileSubmenuPage (WebDriver driver) {
    }

    @FindBy(xpath = "//*[@data-test-id='ak-spotlight-target-profile-spotlight']")
    private WebElement profileIcon;

    @FindBy(xpath = "//*[@href='/logout']")
    private WebElement logoutLink;

}
