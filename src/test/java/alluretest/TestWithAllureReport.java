package alluretest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestWithAllureReport {

    @Test
    void issueSearchTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-button").click();
        $("[name=query-builder-test]").setValue("eroshenkoam/allure-example").pressEnter();
        $$("div.kXssRI").first().$("a").click();
        $("#issues-tab").click();
        $(withText("#80")).should(exist);
    }
}
