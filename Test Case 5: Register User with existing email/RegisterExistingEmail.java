import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class RegisterExistingEmail {
    public static void main(String[] args) throws Exception {
        // Setting system properties for the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\WebDriver\\chromedriver.exe");

        // Launching Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigating to the website
        driver.get("http://automationexercise.com");

        // Verifying that the home page is visible successfully
//        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space(text())='Automation']//ancestor::h1")).isDisplayed());
        WebElement HomePage = driver.findElement(By.xpath("//span[normalize-space(text())='Automation']//ancestor::h1"));
        if (HomePage.isDisplayed()) {
            System.out.println("'Home page is visible successfully'");
        }

        // Click on Signup/Login button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // Verify 'New User Signup!' is visible
//        String newUser = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText();
//        Assert.assertEquals(newUser, "New User Signup!");

        WebElement newUser = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        if (newUser.isDisplayed()){
            System.out.println("'New User Signup!' is visible");
        }

        // Enter name and already registered email address

        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Quang Thang");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("Haquangthang2011@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();

        // Verify error 'Email Address already exist!' is visible
//        String existEmail = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p")).getText();
//        Assert.assertEquals(existEmail, "Email Address already exist!");

        WebElement existEmail = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
        if (existEmail.isDisplayed()){
            System.out.println("'Email Address already exist!' is visible");
        }
        // Close the browser
        Thread.sleep(3000);
        driver.quit();
    }
}
