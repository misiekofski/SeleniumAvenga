package advanced;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void basicAjaxTest() {
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");

        WebElement category = driver.findElement(By.id("combo1"));
        Select categorySelect = new Select(category);
        categorySelect.selectByVisibleText("Desktop");

        // "#ajaxBusy" loader is shown, wait until it becomes invisible
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));

        WebElement language = driver.findElement(By.id("combo2"));
        Select languageSelect = new Select(language);
        languageSelect.selectByVisibleText("C");

        driver.findElement(By.name("submitbutton")).click();

        // now we validate
        WebElement idElement = driver.findElement(By.id("_valueid"));
        WebElement languageIdElement = driver.findElement(By.id("_valuelanguage_id"));

        assertEquals(idElement.getText(),"2");
        assertEquals(languageIdElement.getText(),"12");
    }
}
