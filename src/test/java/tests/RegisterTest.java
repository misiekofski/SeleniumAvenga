package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest extends BaseTest {
    @Test
    void testUserRegistration() {
        driver.get("https://react-redux.realworld.io");
        RegistrationPage rp = new RegistrationPage(driver);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        rp.registerAs("memem"+timestamp.getTime()+"@gmail.com",
                "memem"+timestamp.getTime()+"@gmail.com",
                "memem"+timestamp.getTime()+"@gmail.com");

        assertEquals("memem"+timestamp.getTime()+"@gmail.com", rp.getLoggedUserName());
    }
}
