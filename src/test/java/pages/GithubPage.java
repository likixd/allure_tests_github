//моя плохая попытка сделать page object
//package pages;
//
//import com.codeborne.selenide.SelenideElement;
//
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.open;
//import static org.openqa.selenium.By.linkText;
//
//public class GithubPage {
//    //elements
//    private final SelenideElement searchButton = $("button[aria-label^='Search or jump to']");
//    private final SelenideElement searchInput =  $("input[aria-label='Search or jump to']");
//    private final SelenideElement issueTab = $("a[data-tab-item='issues']");
//    private final String searchButton2 = "button[aria-label^='Search or jump to']";
//    //actions
//    public GithubPage openPage(String value) {
//        open(value);
//
//        return this;
//    }
//
//    public GithubPage searchClickButton () {
//        searchButton.click();
//
//        return this;
//    }
//
//    public GithubPage searchInputClick () {
//        searchInput.click();
//
//        return this;
//    }
//
//    public GithubPage searchInputEnter () {
//        searchInput.pressEnter();
//
//        return this;
//    }
//
//    public GithubPage typeSearchRepo(String value){
//        searchInput.sendKeys(value);
//
//        return this;
//    }
//
//    public GithubPage clickLink (String value) {
//        (linkText(value)).click();
//
//        return this;
//    }
//
//    public GithubPage issueTabOpen () {
//        issueTab.click();
//
//        return this;
//    }
//}
