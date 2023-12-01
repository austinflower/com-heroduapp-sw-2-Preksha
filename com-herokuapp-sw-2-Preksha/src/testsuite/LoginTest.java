package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = " http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowse(baseUrl);

    }

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String actualText = driver.findElement(By.xpath("//div[@id='content']/div/h2")).getText();
        String ExpectedText = "Secure Area";
        Assert.assertEquals(actualText, ExpectedText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String actualText1 = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        System.out.println(actualText1);
        String ExpectedText1 = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(actualText1, ExpectedText1);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String actualText2 = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        //System.out.println(actualText2);
        String ExpectedText2 ="Your password is invalid!\n" +
                "×";
        Assert.assertEquals(actualText2,ExpectedText2);


    }
}