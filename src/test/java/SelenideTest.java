import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    void testIssueSearch() {
        open("https://github.com");
        $("button[aria-label^='Search or jump to']").click();
        $("input[aria-label='Search or jump to']").sendKeys("likixd/allure_tests_github");
        $("input[aria-label='Search or jump to']").pressEnter();
        $(linkText("likixd/allure_tests_github")).click();
        $("a[data-tab-item='issues']").click();
        $(withText("privet")).should(Condition.exist);
    }
}


