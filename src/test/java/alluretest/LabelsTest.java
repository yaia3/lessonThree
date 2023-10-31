package alluretest;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @DisplayName("Создание Issue для авторизованного пользователя")
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Новгородов А")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://testing.github.com")
    public void testStaticLabels() {
    }

    @Test
    void testDynamicLabels() {
    }
}
