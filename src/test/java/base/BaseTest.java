package base;

import driver.DriverFactory;
import driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setupDriver() {
        driver = DriverFactory.CHROME.getDriverManager().getDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
