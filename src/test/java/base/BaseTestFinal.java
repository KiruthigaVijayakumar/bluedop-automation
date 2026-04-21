package base;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTestFinal {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setup() {

        playwright = Playwright.create();

        boolean isCI = System.getenv("CI") != null;

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(isCI) // 🔥 CI → true, Local → false
        );

        page = browser.newPage();
    }

    @AfterMethod
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}

