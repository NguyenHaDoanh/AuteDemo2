import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class LogOutTest {

    public static void main(String[] args) throws InterruptedException {
        // Setting system properties for the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\WebDriver\\chromedriver.exe");

        // Launching Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigating to the website
        driver.get("http://automationexercise.com");

        // Verifying that the home page is visible successfully
        WebElement HomePage = driver.findElement(By.xpath("//span[normalize-space(text())='Automation']//ancestor::h1"));
        if (HomePage.isDisplayed()) {
            System.out.println("'Home page is visible successfully'");
        }
//        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space(text())='Automation']//ancestor::h1")).isDisplayed());

        // Click on Signup/Login button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // Verify Login to your account is visible
//        String Login = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).getText();
//        Assert.assertEquals(Login, "Login to your account");
        WebElement loginAcc =  driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
        if (loginAcc.isDisplayed()){
            System.out.println("'Login to your account' is visible");
        }

        // Enter correct email address and password and click login button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("Haquangthang2011@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("24112013");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();

        // Verify that 'Logged in as username' is visible
        WebElement loginAs = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        WebElement loginStatusName = driver.findElement(By.xpath("//b[contains(text(),'Quang Thang')]"));
        if (loginAs.isDisplayed() && loginStatusName.isDisplayed()){
            System.out.println("'Logged in as username' is visible");
        }

        //Click Logout button
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

        // Quit the browser
        Thread.sleep(3000);
        driver.quit();
    }
}

