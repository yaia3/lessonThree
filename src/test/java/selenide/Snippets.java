package selenide;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    void browser_command_examples() {
        Configuration.baseUrl = "https://www.amazon.com";
        open("https://www.google.ru/");
        open("/customer/orders");
        open("/", AuthenticationType.BASIC,
                new BasicAuthCredentials("", "login", "password"));

        Selenide.back();
        Selenide.refresh();

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        executeJavaScript("sessionStorage().clear();");

        Selenide.confirm(); //нажатие на ок в встроенных модалках браузеров
        Selenide.dismiss(); //нажатие на отмена в встроенных модалках браузеров

        Selenide.closeWindow(); //закрытие активного окна
        Selenide.closeWebDriver();//закрытие браузера

        Selenide.switchTo().window("The internet");//переход между окнами

        Selenide.switchTo().frame("new");
        Selenide.switchTo().defaultContent();

        var cookie = new Cookie("foo", "bar");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        WebDriverRunner.getWebDriver().manage().deleteCookie(cookie);
    }

    void selectors_example() {
        $("div").click();
        element("div").click();

        $("div", 2).click();

        $x("//h1/div").click();
        $(byXpath("//h1/div")).click();

        $(byText("full text")).click();
        $(withText("ull te")).click();

        $(byTagAndText("div", "full text")).click();
        $(withTagAndText("div", "ul te")).click();

        $("").parent();
        $("").sibling(1);
        $("").preceding(1);
        $("").closest("div");
        $("").ancestor("div");
        $("div:last-child");

        $("div").$("h1").find(byText("abc")).click();
    }

    void actions_examples() {
        $("").click();
        $("").doubleClick();
        $("").contextClick();

        $("").hover();

        $("").setValue("text");
        $("").append("text"); //добавить в конец
        $("").clear();
        $("").setValue(""); //clear

        $("div").sendKeys("c"); //нажатие на клавишу
        actions().sendKeys("c").perform();
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); //Ctrl + f
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

        $("").selectOption("dropdown_option"); //dropdown
        $("").selectRadio("radio_option"); // чек боксы
    }

    void assertions_examples() {
        $("").shouldBe(visible);
        $("").shouldNotBe(visible);
        $("").shouldHave(text("asd"));
        $("").shouldNotHave(text("asd"));
        $("").should(appear);
        $("").shouldNot(appear);

        $("").shouldBe(visible, Duration.ofSeconds(30));
    }

    void conditions_examples() {
        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("asd"));
        $("").shouldHave(exactText("asd"));
        $("").shouldHave(textCaseSensitive("asd"));
        $("").shouldHave(exactTextCaseSensitive("asd"));
        $("").should(matchText("[8-9]abc$"));

        $("").shouldHave(cssClass("red"));
        $("").shouldHave(cssValue("fant-size", "12"));

        $("").shouldHave(value("25"));
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(empty);

        $("").shouldHave(attribute("disabled"));
        $("").shouldHave(attribute("name", "example"));
        $("").shouldHave(attributeMatching("name", "[8-9]abc$"));

        $("").shouldBe(checked);

        $("").should(exist);

        $("").shouldBe(disabled);
        $("").shouldBe(enabled);
    }

    void collections_examples(){

        $$("div");

        $$x("//div");

        $$("div").filterBy(text("123")).shouldHave(size(1));
        $$("div").excludeWith(text("123")).shouldHave(size(1));

        $$("div").last().click();
        elements("div").first().click();
        $$("div").get(1).click();
        $("div", 1).click();
        $$("div").findBy(text("123")).click();

        $$("").shouldHave(size(0));
    }

    void file_operations_examples() throws FileNotFoundException{

        File file1 = $("a.filelink").download();
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER));

        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readme.txt");
        $("uploadButton").click();
    }
}
