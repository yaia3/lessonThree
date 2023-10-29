package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        // ARRANGE
        // ACT
        //ASSERT

        //открыть главную страницу
        open("https://github.com/");
        //ввести в поле поиска selenide и нажать enter
        $("[placeholder=\"Search or jump to...\"]").click();
        $("[name=query-builder-test]").setValue("selenide").pressEnter();
        sleep(5000);
        //выбрать первый репозиторий из списка найденных
        $$("div.kXssRI").first().$("a").click();
        //проверка: заголовок selenide/selenide
        $("[id=repository-container-header]").shouldHave(Condition.text("selenide / selenide"));
    }
}
