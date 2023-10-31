package alluretest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Ищем репозиторий")
    public void searchForRepository(String repo){
        $(".header-search-button").click();
        $("[name=query-builder-test]").setValue(repo).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория")
    public void ClickOnRepository(String repo){
        $$("div.kXssRI").first().$("a").click();
    }

    @Step("Открываем таб Issues")
    public void openIssueTab(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issues с номером")
    public void shouldSeeIssueWithNumber(int number){
        $(withText("#" + number)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
