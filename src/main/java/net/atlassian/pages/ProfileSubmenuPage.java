package net.atlassian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileSubmenuPage extends PageBase{
    public ProfileSubmenuPage (WebDriver driver) {
    }

    @FindBy(xpath = "//*[@data-test-id='ak-spotlight-target-profile-spotlight']")
    private WebElement profileIcon;

    @FindBy(xpath = "//*[@href='/logout']")
    private WebElement logoutLink;

    public void clickProfileIcon() {
        profileIcon.click();
    }

    public void clickLogoutLink(){
        logoutLink.click();
    }
}
