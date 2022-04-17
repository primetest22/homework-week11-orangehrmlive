package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        //find forgotpassword link and click
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
        forgotPasswordLink.click();

        String expectedDisplay = "Forgot Your Password?";
        String actualDisplay =
                driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]")).getText();

        //validate expected and actual display message
        Assert.assertEquals("Not Matching", expectedDisplay, actualDisplay);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
