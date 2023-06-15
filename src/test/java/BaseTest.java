import lombok.extern.log4j.Log4j2;
import net.atlassian.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.ResourceBundle;

@Log4j2
public class BaseTest {

    protected WebDriver driver;
    static ResourceBundle bundle = ResourceBundle.getBundle("test");
    private final String URL = bundle.getString("path_to_url");

    @BeforeTest
    public void setUp() {
        log.info("BeforeTest - setUp");
        driver = DriverManager.getDriver();
    }

    @BeforeMethod
    public void getHomePage() {
        log.info("BeforeMethod - getHomePage");
        driver = DriverManager.getDriver();
        driver.get(URL);
    }

    @AfterTest
    public void tearDown() {
        log.info("AfterTest - tearDown");
        DriverManager.closeDriver();
    }

}
