package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //find admin field and send text
        WebElement admin = driver.findElement(By.id("txtUsername"));
        admin.sendKeys("Admin");
        //find password field and send text
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin123");
        //find login button element and click on it
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

        String expectedDisplay = "Welcome Paul";
        WebElement actualDisplayElement = driver.findElement(By.xpath("//a[@id='welcome']"));
        String actualDisplay = actualDisplayElement.getText();
        //validate expected and actual message
        Assert.assertEquals("Not Matching", expectedDisplay, actualDisplay);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
