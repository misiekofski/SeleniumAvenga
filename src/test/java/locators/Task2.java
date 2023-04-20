package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {
        String url = "https://the-internet.herokuapp.com/shifting_content/list";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // działa jeżeli tekst się zaczyna
        // WebElement div = driver.findElement(By.xpath("//div[contains(text(), 'Et numquam et aliquam.')]"));

        // działa w dowolnym miejscu
        WebElement div = driver.findElement(By.xpath("//*[text()[contains(.,'Et numquam et aliquam.')]]"));

        System.out.println(div.getText());
        driver.quit();
    }
}
