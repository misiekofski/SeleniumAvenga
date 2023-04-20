package bidi;

import base.BaseTest;
import com.google.common.net.MediaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.NetworkInterceptor;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.http.Route;

import static org.openqa.selenium.remote.http.Contents.utf8String;

class MockNetworkTest extends BaseTest {
    @Test
    void mockNetworkTest() {
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        try (NetworkInterceptor ignored = new NetworkInterceptor(
                driver,
                Route.matching(req -> req.getUri().contains("youtube"))
                        .to(() -> req -> new HttpResponse()
                                .setStatus(200)
                                .addHeader("Content-Type", MediaType.HTML_UTF_8.toString())
                                .setContent(utf8String("It's blocked"))))) {

            driver.get("https://www.youtube.com/");

            String source = driver.getPageSource();
            Assertions.assertTrue(source.contains("It's blocked"));
        }
    }
}
