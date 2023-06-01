import net.atlassian.pages.LoginPage;
import net.atlassian.pages.ProfileSubmenuPage;
import net.atlassian.pages.SearchFieldPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class JiraTest extends TestBase{
    static ResourceBundle bundle = ResourceBundle.getBundle("test");
    private final String URL = bundle.getString("path_to_url");

    private LoginPage loginPage;
    private SearchFieldPage searchFieldPage;
    private ProfileSubmenuPage profileSubmenuPage;

    @BeforeClass
    public void preparationForTest() {
        driver.get(URL);
        loginPage = new LoginPage(driver);
        searchFieldPage = new SearchFieldPage(driver);
        profileSubmenuPage = new ProfileSubmenuPage(driver);
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {

        loginPage.enterEmail("ny.tests@bk.ru");
        loginPage.clickContinueButton();
        loginPage.enterPassword("UaEsKI12rea(");
        loginPage.clickLoginButton();
        Thread.sleep(3000);//temporary solution

        Assert.assertEquals(driver.getTitle(), "Atlassian");
    }

    @Test(priority = 2)
    public void clearSearchField() {

        searchFieldPage.enterValueInSearchField("value");
        searchFieldPage.clearSearchField();

        Assert.assertEquals(searchFieldPage.getSearchFieldText(), "");
    }

    @Test(priority = 3)
    public void logout(){

        profileSubmenuPage.clickProfileIcon();
        profileSubmenuPage.clickLogoutLink();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://id.atlassian.com/logout"));
    }
}
