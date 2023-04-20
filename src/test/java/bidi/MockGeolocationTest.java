package bidi;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v111.emulation.Emulation;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MockGeolocationTest extends BaseTest {
    @Test
    void mockGeolocation() {
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setGeolocationOverride(Optional.of(52.5043),
                Optional.of(13.4501),
                Optional.of(1)));
        driver.get("https://my-location.org/");
        WebElement yourLocation = driver.findElement(By.id("address"));
        assertThat(yourLocation.getText()).contains("Berlin, Germany");
    }
}
