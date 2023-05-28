import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;

import java.time.Duration;

public class JiraTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver_mac_arm64/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://ny-auto-tests.atlassian.net");
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        emailField.sendKeys("ny.tests@bk.ru");

        WebElement continueButton = driver.findElement(By.id("login-submit"));
        continueButton.click();

        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        passwordField.sendKeys("UaEsKI12rea(");

        WebElement loginButton = driver.findElement(By.id("login-submit"));
        loginButton.click();

        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Atlassian");
    }

    @Test(priority = 2)
    public void clearSearchField() {
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test-id='search-dialog-input']")));
        searchField.sendKeys("board");

        WebElement clearSearchIcon = driver.findElement(By.xpath("//*[@aria-label='Clear search session']"));
        clearSearchIcon.click();

        Assert.assertEquals(searchField.getText(), "");
    }

    @Test(priority = 3)
    public void logout(){
        WebElement profileIcon = driver.findElement(By.xpath("//*[@data-test-id='ak-spotlight-target-profile-spotlight']"));
        profileIcon.click();

        WebElement loginLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@href='/logout']")));
        loginLink.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://id.atlassian.com/logout"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
