import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import utils.AllureAttachments;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void configurationBrowser() {
        Configuration.browser = "chrome";
       // Configuration.browserVersion = "157.0.8103.78";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @AfterEach
    void closeDriver() {
        AllureAttachments.takeScreenshot();
        closeWebDriver();
    }
}
