package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://react-redux.realworld.io");
    }

    @Test
    void testUserRegistration() {
        RegistrationPage rp = new RegistrationPage(driver);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        rp.registerAs("memem"+timestamp.getTime()+"@gmail.com",
                "memem"+timestamp.getTime()+"@gmail.com",
                "memem"+timestamp.getTime()+"@gmail.com");

        assertEquals("memem"+timestamp.getTime()+"@gmail.com", rp.getLoggedUserName());
    }
}
