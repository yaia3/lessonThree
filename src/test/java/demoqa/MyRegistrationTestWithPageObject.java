package demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class MyRegistrationTestWithPageObject extends TestBase {
    @Test
    void successfulRegistration() {

        registrationPage.openPage()
                        .setFirstName("Test")
                        .setLastName("Test2")
                        .setEmail("test@test.te")
                        .setGender("Male")
                        .setNumber("8888888888")
                        .setBirthDate("15", "July", "2000");

        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Тестовая 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Mobile", "8888888888");

//        $(".modal-content").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text("Test"),
//                text("test@test.te"), text("8888888888"));

    }

}
