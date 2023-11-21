package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseURL = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username field and type
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("tomsmith");
        //find password field and enter password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //click on login button
        driver.findElement(By.xpath("//i")).click();
        //verify the text secure area
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2[normalize-space()='Secure Area']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void usernameWithUsernameErrorMessage() {
        //find username field and type
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("tomsmith1");
        //find password field and enter password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //click on login button
        driver.findElement(By.xpath("//i")).click();
        //verify the error message
        String expectedErrorMessage = "Your username is invalid!\n×";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

        @Test
         public void usernameWithPasswordErrorMessage() {
        //find username field and type
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("tomsmith");
        //find password field and enter password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        //click on login button
        driver.findElement(By.xpath("//i")).click();
        //verify the error message
        String expectedErrorMessage = "Your password is invalid!\n×";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='flash-messages']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }

    @After
    public void teardown() {
        closeBrowser();
    }
}
