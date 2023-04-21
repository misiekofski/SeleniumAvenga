package driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverManager extends DriverManager {
        private static URL gridAddress;
        private static WebDriver browserObject;

        @Override
        protected WebDriver createDriver() {
            try {
                gridAddress = new URL("http://localhost:4444");
            } catch (MalformedURLException e) {
            }

            MutableCapabilities options = new ChromeOptions();

            if (gridAddress != null) {
                browserObject = RemoteWebDriver.builder().oneOf(options).address(gridAddress).build();
            } else {
                browserObject = RemoteWebDriver.builder().oneOf(options).build();
            }
            return browserObject;
        }

        private ChromeOptions getChromeOptions() {
            // A few valid Options for Chrome, showcase purpose.
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            options.addArguments("--headless=new");
            options.addArguments("--disable-features=EnableEphemeralFlashPermission");
            options.addArguments("--disable-infobars");

            return options;
        }

}
