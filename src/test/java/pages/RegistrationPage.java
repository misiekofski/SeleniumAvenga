package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegistrationPage {
    WebDriver driver;

    @FindBy(css = "#main > div > nav > div > ul > li:nth-child(3) > a")
    WebElement signUpLink;

    @FindBy(css = "input")
    List<WebElement> registrationInputs;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerAs(String username, String email, String password) {
        signUpLink.click();

        // this will have three items 0 - username, 1 email, 2 -password
        registrationInputs.get(0).sendKeys(username);
        registrationInputs.get(1).sendKeys(email);
        registrationInputs.get(2).sendKeys(password);
        registrationInputs.get(2).submit();
    }

    public String getLoggedUserName() {
        WebElement registeredUser = driver.findElement(By.cssSelector("li.nav-item:nth-child(4) > a:nth-child(1)"));
        String registeredUserName = registeredUser.getText();
        return registeredUserName;
    }
}