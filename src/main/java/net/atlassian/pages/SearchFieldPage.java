package net.atlassian.pages;

import net.atlassian.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFieldPage extends PageBase {

    public SearchFieldPage (WebDriver driver) {
    }

    @FindBy(xpath = "//*[@data-test-id='search-dialog-input']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@aria-label='Clear search session']")
    private WebElement clearSearchIcon;

    public void enterValueInSearchField(String value) {
        Waiters.waitForVisibility(searchField);
        searchField.sendKeys(value);
    }

    public void clearSearchField() {
        clearSearchIcon.click();
    }

    public String getSearchFieldText() {
        return searchField.getText();
    }
}

