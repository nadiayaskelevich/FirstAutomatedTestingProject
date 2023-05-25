import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class XPathHomeWork {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver_mac_arm64/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://ny-auto-tests.atlassian.net/");
    }

    @Test
    public void quickTestWithXPath() throws InterruptedException {
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='username']")));
        emailField.sendKeys("test_jira@bk.ru");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id='login-submit']"));
        continueButton.click();

        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='password']")));
        passwordField.sendKeys("6iv3cumFNu89Du9");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-submit']"));
        loginButton.click();

        Thread.sleep(3000);//temporary solution
        Assert.assertEquals(driver.getTitle(), "Atlassian");

        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test-id='search-dialog-input']")));
        searchField.sendKeys("board");

        WebElement clearSearchIcon = driver.findElement(By.xpath("//*[@aria-label='Clear search session']"));
        clearSearchIcon.click();

        Assert.assertEquals(searchField.getText(), "");

        WebElement profileIcon = driver.findElement(By.xpath("//*[@data-test-id='ak-spotlight-target-profile-spotlight']"));
        profileIcon.click();

        WebElement loginLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@href='/logout']")));
        loginLink.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://id.atlassian.com/logout"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
