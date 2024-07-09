package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.stream.Stream;

public class LocalizationServiceImplTests {




    @MethodSource
    @ParameterizedTest
    public void parametrizedtestlocale(Country country,String expected){

        // given:
        LocalizationServiceImpl sut = new LocalizationServiceImpl();

        // when:
        String act = sut.locale(country);

        // then:
        Assertions.assertEquals(expected,act);

    }

    public static Stream<Arguments> parametrizedtestlocale() {
        return Stream.of(
                Arguments.of(Country.RUSSIA,"Добро пожаловать"),
                Arguments.of(Country.USA,"Welcome"),
                Arguments.of(Country.BRAZIL,"Welcome"),
                Arguments.of(Country.GERMANY,"Welcome"));
    }




}
