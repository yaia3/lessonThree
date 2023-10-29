package demoqa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @Test
    void testBoxSuccessful() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("имя");
        $("#userEmail").setValue("почта@почта.qw");
        $("#currentAddress").setValue("адрес");
        $("#permanentAddress").setValue("адрес2");

        $("#submit").click();
    }
}
