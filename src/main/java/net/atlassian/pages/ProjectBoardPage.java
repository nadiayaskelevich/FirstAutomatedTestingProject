package net.atlassian.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@Getter
public class ProjectBoardPage extends BasePage{
    public ProjectBoardPage (WebDriver driver) {
    }

    @FindBy(xpath = "//p[@data-testid='deep-dive-card-content--project-name-heading']")
    private WebElement recentProjectTitle;

    @FindBy(xpath = "//div[@data-test-id='platform-card.ui.card.focus-container']")
    private List<WebElement> issueCards;

    @FindBy(xpath = "//button[contains(@aria-label, 'issue actions')]")
    private WebElement issueActionsButton;

    @FindBy(xpath = "//button[@data-key='delete']")
    private WebElement deleteIssueButton;

    @FindBy(xpath = "//button[@data-testid='software-board.modals.issue-delete.delete-button']")
    private WebElement confirmDeleteButton;

    public WebElement getFirstIssueCard() {
        return issueCards.get(0);
    }

}
