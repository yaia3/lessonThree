package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {

    @Test
    void bestContributor() {

        open("https://github.com/selenide/selenide");
        $$("div.BorderGrid-cell ul").first().$("a").hover();
        $(".Truncate-text").shouldHave(Condition.text("Andrei Solntsev"));
    }
}
