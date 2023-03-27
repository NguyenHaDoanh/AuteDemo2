import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ContactUsTest {
    public static void main(String[] args) throws InterruptedException {
        // Setting system properties for the Chrome driver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        // Launching Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigating to the website
        driver.get("http://automationexercise.com");

        // Verifying that the home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space(text())='Automation']//ancestor::h1")).isDisplayed());

        // Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[normalize-space(text())='Contact us']")).click();

        // Verify 'GET IN TOUCH' is visible
        String touch = driver.findElement(By.xpath("//h2[normalize-space(text())='Get In Touch']")).getText();
        Assert.assertEquals(touch, "GET IN TOUCH");

        // Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("son truong");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sontruong@gmail.com");
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("subject1");
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("hello how are u?");

        // Upload file
        WebElement fileUpload = driver.findElement(By.xpath("//input[@name='upload_file']"));
        fileUpload.sendKeys("/usr/local/bin/text.txt");
        Thread.sleep(5000);

        // Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // Click OK button
        driver.switchTo().alert().accept();

        // Verify success message 'Success! Your details have been submitted successfully.'
        String success = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        Assert.assertEquals(success, "Success! Your details have been submitted successfully.");

        // Click on 'Home' button
        driver.findElement(By.xpath("//span[normalize-space(text())='Home']//parent::a")).click();

        // Close browser
        driver.quit();
    }
}





