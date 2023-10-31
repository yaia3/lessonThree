package alluretest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;
    @Test
    void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () ->{
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("[name=query-builder-test]").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке репозитория" + REPOSITORY, () ->{
            $$("div.kXssRI").first().$("a").click();
        });
        step("Открываем таб Issues " + REPOSITORY, () ->{
           $("#issues-tab").click();
       });
        step("Проверяем наличие Issues с номером " + ISSUE, () ->{
           $(withText("#" + ISSUE)).should(Condition.exist);
       });
    }

    @Test
    public void testAnnotated(){

        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.ClickOnRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}
