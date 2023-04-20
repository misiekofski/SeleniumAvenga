package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    public static void main(String[] args) {
        String url = "https://the-internet.herokuapp.com/shifting_content/menu?mode=random";
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement portfolioButton = driver.findElement(By.xpath("//a[text()='Portfolio']"));

        System.out.println(portfolioButton.getText());
        driver.quit();
    }
}
