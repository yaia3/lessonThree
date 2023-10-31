package JUniLearn;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnitSimpleTest {

    @BeforeEach // Предусловия
    void setUp(){}

    @Test // указывает что это тест
    @DisplayName("Первый тест") // Имя теста, используется в allure
    @Disabled // Тест отключен
    @Tag("#BLOCKER")
    void simpleTest() {

    }

    @ValueSource(strings = {"qwe", "asd"})
    @CsvSource({
            "test, test",
            "test2, test2"
    })
    // OR
    @CsvFileSource(resources = "/test.csv")
    @ParameterizedTest(name = "Название теста {0}, Название теста {1}")
    void parametrizeTest(
            String testName,
            String testName2
    ){

    }

}
