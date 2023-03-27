import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyTestCase {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set the path of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("http://automationexercise.com");
    }

    @Test(priority = 1)
    public void verifyHomePage() {
        // Verify the home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2)
    public void navigateToTestCasesPage() {
        // Click on the "Test cases" button
        driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]")).click();

        // Verify the user is navigated to the test cases page successfully
        String expectedTitle = "Automation Practice Website for UI Testing - Test Cases";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterClass
    public void teardown() {
        // Close the browser
        driver.quit();
    }
}
