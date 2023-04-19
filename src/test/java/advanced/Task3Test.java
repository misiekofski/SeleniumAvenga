package advanced;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    void testDynamicTable() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/expandingdiv.html");

        WebElement expandingDiv = driver.findElement(By.cssSelector(".expand"));
        Actions action = new Actions(driver);
        action.moveToElement(expandingDiv);
        action.perform();

        // TODO add wait
        var linkToClick = expandingDiv.findElement(By.tagName("a"));
        linkToClick.click();

        var header = driver.findElement(By.xpath("//h1"));
        assertEquals(header.getText(), "You clicked the link in the expanding div");
    }
}