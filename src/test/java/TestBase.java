import net.atlassian.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @AfterTest
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
