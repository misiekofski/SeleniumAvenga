package advanced;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5Test extends BaseTest {
    @Test
    void uploadFile(){
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        WebElement fileInput = driver.findElement(By.id("fileinput"));
        String pathToFile = "C:\\downloads\\cat.jpg";
        fileInput.sendKeys(pathToFile);

        WebElement imageCheckbox = driver.findElement(By.id("itsanimage"));
        imageCheckbox.click();
        WebElement uploadButton = driver.findElement(By.name("upload"));
        uploadButton.click();
    }
}
