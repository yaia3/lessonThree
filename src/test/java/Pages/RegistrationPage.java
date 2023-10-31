package Pages;

import Pages.components.CalendarComponent;
import Pages.components.RegitrationResultModal;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegitrationResultModal regitrationResultModal = new RegitrationResultModal();

    private SelenideElement
            lastNameInput = $("#lastName"),
            firstNameinput = $("#firstName"),
            emailInput = $("#userEmail");
    private final String TITLE_TEXT = "Practice Form";

    public RegistrationPage openPage(){
        open("/automation-practice-form");

        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameinput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value){
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears(){
        regitrationResultModal.verifyModalAppears();
        $(".table-responsive").shouldHave(text("Test"),
                text("test@test.te"), text("8888888888"));

        return this;
    }

    public RegistrationPage verifyResults(String key, String value){
        regitrationResultModal.verifyResult(key, value);

        return this;
    }
}
