import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
          options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp = new DesiredCapabilities();
            cp.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(cp);

        System.setProperty("webdriver.chrome.driver","D:\\Application\\chromedriver.exe" );
        driver = new ChromeDriver(options);
        //Set timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Launching browser
        driver.get("http://automationexercise.com");
        // Verify that the home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle))
            System.out.println("Home page is visible successfully");
        else
            System.out.println("Home page is not visible successfully");

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Click on the "Sign up/login" button
        WebElement signupLoginButton = driver.findElement(By.xpath("//a[contains(.,' Signup / Login')]"));
        signupLoginButton.click();
       // driver.findElement(By.xpath("//a[contains(.,' Signup / Login')]")).click();
        //Thread.sleep(500);
        // Verify that "New User Signup!" is visible
        WebElement newUserSignupHeading = driver.findElement(By.xpath("//h2[contains(.,'New User Signup!')]"));
        if(newUserSignupHeading.getText().equals("New User Signup!"))
            System.out.println("New user Signup! is visible");
        else
            System.out.println("New User Signup! is not visible");
        //Enter name and email address and click "Signup" button
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Quynh");
        WebElement emailField = driver.findElement( By.xpath("//*[@data-qa='signup-email']"));
        emailField.sendKeys("quynh16@example.com");
        WebElement signupButton = driver.findElement(By.xpath("//button[contains(.,'Signup')]"));
        signupButton.click();

        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInfoHeading = driver.findElement(By.xpath("//b[contains(.,'Enter Account Information')]"));
        if(enterAccountInfoHeading.getText().equals("ENTER ACCOUNT INFORMATION"))
            System.out.println("Enter Account Information is visible");
        else
            System.out.println("Enter Account Information is not visible");

        // Fill details: Title, Name, Email, Password, Date of birth
        WebElement titleField = driver.findElement(By.id("id_gender1"));
        titleField.click();
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Quynh123");
        WebElement yearField = driver.findElement(By.id("years"));
        yearField.sendKeys("2000");
        WebElement monthField = driver.findElement(By.id("months"));
        monthField.sendKeys("November");
        WebElement dayField = driver.findElement(By.id("days"));
        dayField.sendKeys("16");
        //Select checkbox 'Sign up for our newsletter!'
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newsletter")));
        WebElement checkbox1 = driver.findElement(By.id("newsletter"));
        checkbox1.click();
        //Select checkbox 'Receive special offers from our partners!'
        WebElement checkbox2 = driver.findElement(By.id("optin"));
        checkbox2.click();

        //Fill details: First name, Last name, Company, Address,
        // Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameField = driver.findElement(By.id("first_name"));
        firstNameField.sendKeys("Quynh");
        WebElement lastNameField = driver.findElement(By.id("last_name"));
        lastNameField.sendKeys("Le");
        WebElement companyField = driver.findElement(By.id("company"));
        companyField.sendKeys("ABC");
        WebElement addressField = driver.findElement(By.id("address1"));
        addressField.sendKeys("239 Xuan Thuy, NashTech");
        WebElement address2Field = driver.findElement(By.id("address2"));
        address2Field.sendKeys("239 Tran Phu, NashTech");
        WebElement countryField = driver.findElement(By.id("country"));
        countryField.sendKeys("Singapore");
        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("12AB");
        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("Ha Noi");
        WebElement zipcodeField = driver.findElement(By.id("zipcode"));
        zipcodeField.sendKeys("123AV3g");
        WebElement mobileNumberField = driver.findElement(By.id("mobile_number"));
        mobileNumberField.sendKeys("0448644721");

        // Click 'Create Account button'
        WebElement createAccountButton = driver.findElement(By.xpath("//*[@data-qa='create-account']"));
        createAccountButton.click();

       // Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedHeading = driver.findElement(By.xpath("//b[contains(.,'Account Created!')]"));
        if(accountCreatedHeading.getText().equals("ACCOUNT CREATED!"))
            System.out.println("Account Created is visible");
        else
            System.out.println("Account Created is not visible");

        //Click 'Continue' button
        WebElement clickButton = driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
        clickButton.click();
        //Verify that 'Logged in as username' is visible
        WebElement loginAs = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        WebElement loginStatusName = driver.findElement(By.xpath("//b[contains(text(),'Quynh')]"));

        if (loginAs.isDisplayed() && loginStatusName.isDisplayed()){
            System.out.println("'Logged in as username' is visible");
        }
        // Click the delete button
        WebElement deleteButton = driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]"));

        deleteButton.click();

        // Verify that 'ACCOUNT DELETED!' is visible
        WebElement delaccMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));

        if (delaccMessage.isDisplayed()) {
            System.out.println("Account deleted is visible successfully");
        } else {
            System.out.println("Account deleted is not visible");
        }
        // click 'Continue' button
        WebElement continueButton = driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
        continueButton.click();

        driver.quit();
   // }


    }
}


