import lombok.extern.log4j.Log4j2;
import net.atlassian.driver.DriverManager;
import net.atlassian.pages.LoginPage;
import net.atlassian.pages.ProfileSubmenuPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import java.util.ResourceBundle;

@Log4j2
public class BaseTest {

    protected WebDriver driver;
    private LoginPage loginPage;
    private ProfileSubmenuPage profileSubmenuPage;
    static ResourceBundle bundle = ResourceBundle.getBundle("test");
    private final String URL = bundle.getString("path_to_url");

    @BeforeClass
    public void login() {
        log.info("BeforeClass - login");
        driver = DriverManager.getDriver();
        driver.get(URL);

        loginPage = new LoginPage(driver);
        loginPage.enterEmail("ny.tests@bk.ru");
        loginPage.clickContinueButton();
        loginPage.enterPassword("UaEsKI12rea(");
        loginPage.clickLoginButton();
    }

    @AfterClass
    public void logout(){
        log.info("AfterClass - logout");
        profileSubmenuPage = new ProfileSubmenuPage(driver);
        profileSubmenuPage.clickProfileIcon();
        profileSubmenuPage.clickLogoutLink();
    }

    @BeforeTest
    public void setUp() {
        log.info("BeforeTest - setUp");
        driver = DriverManager.getDriver();
    }

    @AfterTest
    public void tearDown() {
        log.info("AfterTest - tearDown");
        DriverManager.closeDriver();
    }
}
