package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests extends TestBase {

    @Test
    void testBoxSuccessful() {

        open("/text-box");

        $(".main-header").shouldHave(text("Text box"));

        $("#userName").setValue("имя");
        $("#userEmail").setValue("pochta@pochta.qw");
        $("#currentAddress").setValue("адрес");
        $("#permanentAddress").setValue("адрес2");

        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text("имя"));
        $("#output").$("#email").shouldHave(text("pochta@pochta.qw"));
//        $("#currentAddress").shouldHave(text("адрес"));
//        $("#permanentAddress").shouldHave(text("адрес2"));
    }
}
