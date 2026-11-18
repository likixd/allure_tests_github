import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.AllureAttachments;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    SelenideTest selenideTest = new SelenideTest();
    StepsTest stepsTest = new StepsTest();


    @BeforeAll
    static void configurationBrowser() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
        new AllureAttachments();
    }
}
