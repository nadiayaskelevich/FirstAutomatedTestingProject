import net.atlassian.models.IssueData;
import net.atlassian.pages.CreateIssuePage;
import net.atlassian.pages.SearchFieldPage;
import net.atlassian.utils.HelpfulActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JiraTest extends BaseTest {

    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    private SearchFieldPage searchFieldPage = new SearchFieldPage(driver);
    private CreateIssuePage createIssuePage = new CreateIssuePage(driver);

    @Test
    public void clearSearchField() {
        logger.info("clearSearchField");

        searchFieldPage.enterValueInSearchField("value");
        searchFieldPage.clearSearchField();
        HelpfulActions.pressEscapeKey(super.driver);

        Assert.assertEquals(searchFieldPage.getSearchFieldText(), "");
    }

    @DataProvider(name = "issueData")
    public static IssueData[][] provideIssueData() {
        return new IssueData[][] {
                {IssueData.builder().summary("Issue").description("Info").build()},
                {IssueData.builder().summary("Summary").description("Description").build()},
        };
    }

    @Test(dataProvider = "issueData")
    public void createIssue(IssueData issueData) {
        logger.info("createIssue");

        createIssuePage.clickCreateButton();
        createIssuePage.enterSummary(issueData.getSummary());
        HelpfulActions.scrollToElement(super.driver, createIssuePage.getDescriptionField());
        createIssuePage.enterDescription(super.driver, issueData.getDescription());
        createIssuePage.clickCreateIssueButton();

        Assert.assertTrue(createIssuePage.createdModalIsDisplayed());
    }
}
