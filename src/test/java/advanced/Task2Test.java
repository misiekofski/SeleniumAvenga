package advanced;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    void testDynamicTable() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

        WebElement tableData = driver.findElement(By.xpath("//summary"));
        tableData.click();

        WebElement textArea = driver.findElement(By.id("jsondata"));
        textArea.click();
        textArea.clear();

        String tableText = "[{\"name\" : \"Bob\", \"age\" : 20}," +
                " {\"name\": \"George\", \"age\" : 42}," +
                " {\"name\": \"John Wick\", \"age\": 44}]";
        textArea.sendKeys(tableText);

        WebElement refreshTableButton = driver.findElement(By.id("refreshtable"));
        refreshTableButton.click();

        WebElement tableElement = driver.findElement(By.id("dynamictable"));
        List<WebElement> tableRows = tableElement.findElements(By.xpath("//tr"));
        assertEquals(4, tableRows.size());
    }
}
