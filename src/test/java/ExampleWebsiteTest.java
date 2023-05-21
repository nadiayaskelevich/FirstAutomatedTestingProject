import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleWebsiteTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver_mac_arm64/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void verifyPageTitle() {
        // Open the website
        driver.get("https://www.example.com");

        // Get the page title
        String pageTitle = driver.getTitle();

        // Assert the page title
        Assert.assertEquals(pageTitle, "Example Domain");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
