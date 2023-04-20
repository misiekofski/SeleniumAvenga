package bidi;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;

import java.net.URI;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;


class BasicAuthLoginTest extends BaseTest {
    @Test
    void basicAuthTest() {
        var url = "https://authenticationtest.com/HTTPAuth/";
        var username = "user";
        var password = "pass";

        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("authenticationtest.com");
        ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of(username, password));
        driver.get(url);

        WebElement headerText = driver.findElement(By.cssSelector("h1"));
        System.out.println(headerText.getText());
        assertThat(headerText.getText()).isEqualTo("Login Success");
    }
}
