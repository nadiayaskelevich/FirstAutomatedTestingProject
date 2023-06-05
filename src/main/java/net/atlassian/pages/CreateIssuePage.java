package net.atlassian.pages;

import net.atlassian.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class CreateIssuePage extends BasePage{

    public CreateIssuePage (WebDriver driver) {
    }

    @FindBy(id = "createGlobalItem")
    private WebElement createButton;

    @FindBy(xpath = "//input[@name='summary']")
    private WebElement summaryField;

    @FindBy(xpath = "//div[contains(@class, 'ak-editor-content-area')]")
    private WebElement descriptionField;

    @FindBy(xpath = "//button[@data-testid='issue-create.common.ui.footer.create-button']")
    private WebElement createIssueButton;

    @FindBy(xpath = "//*[@data-testid='jira-issue-create.modal.create-form.success-flag']")
    private WebElement issueCreatedModal;

    public void clickCreateButton() {
        createButton.click();
    }

    public void enterSummary(String summary) {
        Waiters.waitForVisibility(summaryField);
        summaryField.sendKeys(summary);
    }

    public void enterDescription(WebDriver driver, String text) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].textContent = arguments[1];", descriptionField, text);
    }

    public WebElement getDescriptionField(){
        return descriptionField;
    }

    public void clickCreateIssueButton() {
        createIssueButton.click();
    }

    public boolean createdModalIsDisplayed(){
        return issueCreatedModal.isDisplayed();
    }
}
