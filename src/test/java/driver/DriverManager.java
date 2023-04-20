package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract WebDriver createDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        if (null == driver) {
            driver = this.createDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
