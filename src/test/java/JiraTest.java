import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import lombok.extern.log4j.Log4j2;
import net.atlassian.driver.DriverManager;
import net.atlassian.models.IssueData;
import net.atlassian.steps.AuthorisationSteps;
import net.atlassian.steps.CreateIssueSteps;
import net.atlassian.pages.SearchFieldPage;
import net.atlassian.steps.DeleteIssueSteps;
import net.atlassian.utils.HelpfulActions;
import net.atlassian.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import net.atlassian.utils.AllureListener;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

@Log4j2
@Listeners({AllureListener.class})
public class JiraTest extends BaseTest {

    protected WebDriver driver;
    private AuthorisationSteps authorisationSteps;
    private SearchFieldPage searchFieldPage;
    private CreateIssueSteps createIssueSteps;
    private DeleteIssueSteps deleteIssueSteps;
    static ResourceBundle bundle = ResourceBundle.getBundle("test");
    private final String URL = bundle.getString("path_to_url");

    @BeforeClass
    public void login() {
        log.info("BeforeClass - login");
        driver = DriverManager.getDriver();
        driver.get(URL);
        searchFieldPage = new SearchFieldPage(driver);
        createIssueSteps = new CreateIssueSteps(driver);
        deleteIssueSteps = new DeleteIssueSteps(driver);
        authorisationSteps = new AuthorisationSteps(driver);
        authorisationSteps.login();
    }

    @Test
    @Feature(value = "Search")
    @Description("Check that search field can be cleared clicking cross icon")
    public void clearSearchField() {
        searchFieldPage.enterValueInSearchField("value");
        searchFieldPage.clearSearchField();
        HelpfulActions.pressEscapeKey(driver);

        Assert.assertEquals(searchFieldPage.getSearchFieldText(), "");
    }

    @Test(dataProvider = "issueData", dataProviderClass = JsonReader.class)
    @Feature(value = "Issue")
    @Description("Check that issue with summary and description filled in can be created")
    public void createIssue(IssueData issueData) {
        createIssueSteps.clickCreateButton();
        createIssueSteps.enterSummary(issueData.getSummary());
        createIssueSteps.enterDescription(issueData.getDescription());
        createIssueSteps.clickCreateIssueButton();

        Assert.assertTrue(createIssueSteps.createdModalIsDisplayed());
    }

    @Test
    @Feature(value = "Issue")
    @Description("Delete all created issues")
    public void deleteAllIssues(){
        deleteIssueSteps.deleteAllCreatedIssues(driver);

        Assert.assertFalse(deleteIssueSteps.areThereIssuesLeft());
    }

    @AfterClass
    public void logout(){
        log.info("AfterClass - logout");
        authorisationSteps.logout();
    }

}
