package bidi;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

class JSExceptionsTest extends BaseTest {
    @Test
    void jsExceptionsTest() throws ExecutionException, InterruptedException, TimeoutException {
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        List<JavascriptException> jsExceptionsList = new ArrayList<>();
        devTools.getDomains().events().addJavascriptExceptionListener(jsExceptionsList::add);
        CompletableFuture<JavascriptException> futureJsExc = new CompletableFuture<>();
        devTools.getDomains().events().addJavascriptExceptionListener(futureJsExc::complete);

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement element = driver.findElement(By.tagName("button"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                        element, "onclick", "throw new Error('Hello, world!')");
        element.click();

        futureJsExc.get(5, TimeUnit.SECONDS);
        assertThat(jsExceptionsList).hasSize(1);
    }
}
