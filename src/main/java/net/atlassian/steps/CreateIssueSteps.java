package net.atlassian.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import net.atlassian.pages.CreateIssuePage;
import net.atlassian.utils.Waiters;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CreateIssueSteps {

    private CreateIssuePage createIssuePage;

    public CreateIssueSteps (WebDriver driver) {
        createIssuePage = new CreateIssuePage(driver);
    }

    @Step("Click \"Create\" button")
    public void clickCreateButton() {
        log.info("clickCreateButton");
        createIssuePage.getCreateButton().click();
    }

    @Step("Enter issue summary")
    public void enterSummary(String summary) {
        log.info("enterSummary");
        Waiters.waitForVisibility(createIssuePage.getSummaryField());
        createIssuePage.getSummaryField().sendKeys(summary);
    }

    @Step("Enter issue description")
    public void enterDescription(String description) {
        log.info("enterDescription");
        Waiters.waitForVisibility(createIssuePage.getDescriptionField());
        createIssuePage.getDescriptionField().click();
        createIssuePage.getDescriptionInputField().sendKeys(description);
    }

    @Step("Click \"Create issue\" button")
    public void clickCreateIssueButton() {
        log.info("clickCreateIssueButton");
        createIssuePage.getCreateIssueButton().click();
    }

    @Step("Display issue created modal")
    public boolean createdModalIsDisplayed(){
        log.info("createdModalIsDisplayed");
        return createIssuePage.getIssueCreatedModal().isDisplayed();
    }

}
