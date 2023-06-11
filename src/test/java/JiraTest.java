import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import lombok.extern.log4j.Log4j2;
import net.atlassian.driver.DriverManager;
import net.atlassian.models.IssueData;
import net.atlassian.steps.CreateIssueSteps;
import net.atlassian.pages.SearchFieldPage;
import net.atlassian.utils.HelpfulActions;
import net.atlassian.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Log4j2
public class JiraTest extends BaseTest {

    protected WebDriver driver;
    private SearchFieldPage searchFieldPage;
    private CreateIssueSteps createIssueSteps;

    @BeforeClass
    public void preparationForTest() {
        log.info("BeforeClass - preparationForTest");
        driver = DriverManager.getDriver();
        searchFieldPage = new SearchFieldPage(driver);
        createIssueSteps = new CreateIssueSteps(driver);
    }

    @Test
    @Feature(value = "Search")
    @Description("Check that search field can be cleared clicking cross icon")
    public void clearSearchField() {
        log.info("clearSearchField");

        searchFieldPage.enterValueInSearchField("value");
        searchFieldPage.clearSearchField();
        HelpfulActions.pressEscapeKey(super.driver);

        Assert.assertEquals(searchFieldPage.getSearchFieldText(), "");
    }

    @Test(dataProvider = "issueData", dataProviderClass = JsonReader.class)
    @Feature(value = "Issue")
    @Description("Check that issue with summary and description filled in can be created")
    public void createIssue(IssueData issueData) {
        log.info("createIssue");

        createIssueSteps.clickCreateButton();
        createIssueSteps.enterSummary(issueData.getSummary());
        createIssueSteps.enterDescription(issueData.getDescription());
        createIssueSteps.clickCreateIssueButton();

        Assert.assertTrue(createIssueSteps.createdModalIsDisplayed());
    }
}
