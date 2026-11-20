import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static testdata.TestData.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open(baseUrl);
    }
    @Step("Ищем репозиторий {repo}")
    public void searchFoRepository(String repo){
        $("button[aria-label^='Search or jump to']").click();
        $("input[aria-label='Search or jump to']").sendKeys(repoName);
        $("input[aria-label='Search or jump to']").pressEnter();

    }

    @Step("Кликаем по ссылке репозитория {repo}" )
    public void clickOnRepository(String repo){
        $(linkText(repoName)).click();
    }

    @Step("Открываем вкладку Issues")
    public void openIssueTab(){
        $("a[data-tab-item='issues']").click();
    }

    @Step("Проверяем наличие Issue с текстом {text}")
    public void shouldSeeIssueWithText(String text){
        $(withText(issueSearchText)).should(Condition.exist);

    }
}
