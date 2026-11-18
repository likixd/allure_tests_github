import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static testdata.TestData.*;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {


//    @BeforeAll
//    static void beforeAll(){
//        browserSize= "1920x1080";
//    }

    @Test
    @DisplayName("Открытие вкладки Issue через Listener Selenide")
    @Owner("Gizatullina Rimma")
    void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(baseUrl);
        $("button[aria-label^='Search or jump to']").click();
        $("input[aria-label='Search or jump to']").sendKeys(repoName);
        $("input[aria-label='Search or jump to']").pressEnter();
        $(linkText(repoName)).click();
        $("a[data-tab-item='issues']").click();
        $(withText(issueSearchText)).should(Condition.exist);
    }
//kjhkjhjkh
//    @AfterEach
//    void afterAll() {
//        closeWebDriver();
//    }

}


