package bidi;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static org.awaitility.Awaitility.await;

public class JSErrorLogger extends BaseTest {

    private final List<JavascriptException> jsExceptionsList = new ArrayList<>();

    @Test
    void jsErrorLogger() throws ExecutionException, InterruptedException, TimeoutException {
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.getDomains().events().addJavascriptExceptionListener(jsExceptionsList::add);


        driver.get("http://the-internet.herokuapp.com/javascript_error");

        // default wait time is 10 seconds
        await().until(() -> jsExceptionsList.size() > 0);
    }
}
