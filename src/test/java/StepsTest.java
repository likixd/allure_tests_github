import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static testdata.TestData.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {


    @Test
    @DisplayName("Открытие вкладки Issue через Lambda")
    @Owner("Gizatullina Rimma")
    void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
                open(baseUrl);
        });
        step("Ищем репозиторий "+ repoName, () -> {
            $("button[aria-label^='Search or jump to']").click();
            $("input[aria-label='Search or jump to']").sendKeys(repoName);
            $("input[aria-label='Search or jump to']").pressEnter();
        });
        step("Кликаем по ссылке репозитория " + repoName, () -> {
            $(linkText(repoName)).click();
        });
        step("Открываем вкладку Issues ", () -> {
            $("a[data-tab-item='issues']").click();
        } );
        step("Проверяем наличие Issue с текстом " +issueSearchText, () -> {
            $(withText(issueSearchText)).should(Condition.exist);
//            attachment("Source", webdriver().driver().source());
        });


    }
//kjbjhgjh
    @Test
    @DisplayName("Открытие вкладки Issue через аннотации @Step")
    @Owner("Gizatullina Rimma")
    void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchFoRepository(repoName);
        steps.clickOnRepository(repoName);
        steps.openIssueTab();
        steps.shouldSeeIssueWithText(issueSearchText);
    }

////Для себя
//            step("Открываем главную страницу", new Allure.ThrowableContextRunnableVoid<Allure.StepContext>() {
//            @Override
//            public void run(Allure.StepContext context) throws Throwable {
//                  open(baseUrl);
//            }
//        });
}
