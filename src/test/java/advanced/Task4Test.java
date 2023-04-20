package advanced;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test extends BaseTest {
    @Test
    void testDynamicButtons() {
        driver.get("https://testpages.herokuapp.com/styled/expandingdiv.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement startButton = driver.findElement(By.id("button00"));
        startButton.click();

        var oneButton = driver.findElement(By.id("button01"));
        oneButton.click();

        var twoButton = driver.findElement(By.id("button02"));


        var threeButton = driver.findElement(By.id("button03"));


        var buttonMessage = driver.findElement(By.id("buttonmessage"));
        assertEquals(buttonMessage.getText(), "All buttons clicked");
    }
}
