import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCase2 {

    public static void main(String[] args) {
        
        // set the driver path for Chrome browser
        System.setProperty("webdriver.chrome.driver", "C:/Users/doanh/OneDrive/Desktop/Selenium/TestProject/src/drivers/chromedriver.exe");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        // create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver(options);
        // navigate to the url
        driver.get("http://automationexercise.com");
        
        

        // verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Home page is visible successfully");
        } else {
            System.out.println("Home page is not visible successfully");
        }

        // Click on 'Signup / Login' button
        WebElement signupLoginButton = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
        signupLoginButton.click();
        
        // Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
        if (loginToYourAccount.isDisplayed()) {
            System.out.println("Login to your account is visible successfully");
        } else {
            System.out.println("Login to your account is not visible");
        }        

        // Enter correct email address and password
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("doanhdoanh4801@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("doanh123");

        // locate the login button element
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // click the login button
        loginButton.click();


        // Verify that 'Logged in as username' is visible
        WebElement loginAs = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        WebElement loginStatusName = driver.findElement(By.xpath("//b[contains(text(),'HaDoanh')]"));

        if (loginAs.isDisplayed() && loginStatusName.isDisplayed()){
            System.out.println("'Logged in as username' is visible");
        }
        WebElement deleteButton = driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]"));
        //Click the delete button
        deleteButton.click();

        // Verify that 'ACCOUNT DELETED!' is visible
        WebElement delaccMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));

        if (delaccMessage.isDisplayed()) {
            System.out.println("Account deleted is visible successfully");
        } else {
            System.out.println("Account deleted is not visible");
        }
        // close the browser
        //driver.quit();
    }
}
