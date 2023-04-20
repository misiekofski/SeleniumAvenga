package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        String url = "https://the-internet.herokuapp.com/tables";
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // sort by lastName
        WebElement lastNameSortHeader = driver.findElement(By.xpath("//span[text()='Last Name']"));
        lastNameSortHeader.click();

        List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
        List<String> lastNamesStrings = lastNames
                .stream()
                .map(WebElement::getText)
                .toList();

        System.out.println(lastNamesStrings);
        driver.quit();
    }
}
