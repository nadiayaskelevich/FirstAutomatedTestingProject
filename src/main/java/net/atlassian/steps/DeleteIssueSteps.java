package net.atlassian.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import net.atlassian.pages.ProjectBoardPage;
import net.atlassian.utils.HelpfulActions;
import net.atlassian.utils.Waiters;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DeleteIssueSteps {

    private ProjectBoardPage projectBoardPage;

    public DeleteIssueSteps (WebDriver driver) {
        projectBoardPage = new ProjectBoardPage(driver);
    }

    @Step("Open recent project board")
    public void openRecentProjectBoard() {
        log.info("openRecentProjectBoard");

        projectBoardPage.getRecentProjectTitle().click();
    }

    @Step("Hover over issue card")
    public void hoverOverIssue(WebDriver driver) {
        log.info("hoverOverIssue");

        Waiters.waitForVisibility(projectBoardPage.getFirstIssueCard());
        HelpfulActions.hoverOverElement(driver, projectBoardPage.getFirstIssueCard());
    }

    @Step("Click issue actions button")
    public void clickIssueActionsButton() {
        log.info("clickIssueActionsButton");

        projectBoardPage.getIssueActionsButton().click();
    }

    @Step("Click \"Delete\" button")
    public void clickDeleteIssueButton() {
        log.info("clickDeleteIssueButton");

        projectBoardPage.getDeleteIssueButton().click();
    }

    @Step("Confirm issue deletion")
    public void confirmIssueDeletion() {
        log.info("confirmIssueDeletion");

        projectBoardPage.getConfirmDeleteButton().click();
    }

    @Step("Check if there are any issues left")
    public boolean areThereIssuesLeft() {
        log.info("areThereIssuesLeft");

        return !projectBoardPage.getIssueCards().isEmpty();
    }

    @Step("Delete all created issues")
    public void deleteAllCreatedIssues(WebDriver driver) {
        log.info("deleteAllCreatedIssues");

        openRecentProjectBoard();
        while (areThereIssuesLeft()) {
            hoverOverIssue(driver);
            clickIssueActionsButton();
            clickDeleteIssueButton();
            confirmIssueDeletion();
        }
    }

}
