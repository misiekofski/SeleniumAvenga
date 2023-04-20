package tests;

import base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.*;

public class BadLoginTest extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv")
    void testBadLoginCredentials(String user, String pass) {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput =  driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        if (null==pass) {
            pass = "";
        }

        if (null==user) {
            user = "";
        }

        usernameInput.sendKeys(user);
        passwordInput.sendKeys(pass);
        loginButton.click();

        WebElement message = driver.findElement(By.id("flash"));

        // assertTrue(message.getText().contains("is invalid!"));
        assertThat(message.getText()).startsWith("Your").endsWith("is invalid!\n×");
    }
}

