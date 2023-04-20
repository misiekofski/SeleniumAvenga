package bidi;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v111.performance.Performance;
import org.openqa.selenium.devtools.v111.performance.model.Metric;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PerformanceLogger extends BaseTest {
    private List<Metric> metricList;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        metricList = devTools.send(Performance.getMetrics());
    }

    @Test
    public void shouldCollectPerformanceMetrics() {
        // when
        driver.get("https://scvconsultants.com/");

        // then
        metricList.forEach(PerformanceLogger::logAndAssert);
    }

    private static void logAndAssert(Metric metric) {
        System.out.println(metric.getName() + " : " + metric.getValue());
        assertThat(metric.getValue().longValue()).isGreaterThanOrEqualTo(0);
    }
}
