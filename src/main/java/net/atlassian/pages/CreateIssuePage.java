package net.atlassian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//div[contains(@class, 'ak-editor-content-area')]/div[2]/p")
    private WebElement descriptionInputField;

    @FindBy(xpath = "//button[@data-testid='issue-create.common.ui.footer.create-button']")
    private WebElement createIssueButton;

    @FindBy(xpath = "//*[@data-testid='jira-issue-create.modal.create-form.success-flag']")
    private WebElement issueCreatedModal;

    public WebElement getCreateButton() {
        return createButton;
    }

    public WebElement getSummaryField() {
        return summaryField;
    }

    public WebElement getDescriptionField() {
        return descriptionField;
    }

    public WebElement getDescriptionInputField() {
        return descriptionInputField;
    }

    public WebElement getCreateIssueButton() {
        return createIssueButton;
    }

    public WebElement getIssueCreatedModal() {
        return issueCreatedModal;
    }
}
