package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTests {

    @Test
    public void testsendUsa() {

        // given:
        LocalizationServiceMock localizationServiceMock = new LocalizationServiceMock();
        GeoServiceMock geoServiceMock = new GeoServiceMock();
        MessageSenderImpl sut = new MessageSenderImpl(geoServiceMock,localizationServiceMock);
        Map<String,String> haders = new HashMap<>();
        haders.put(MessageSenderImpl.IP_ADDRESS_HEADER,"111");
        String expected = "Welcome";

        // when:
        String act = sut.send(haders);

        // then:
        Assertions.assertEquals(expected,act);

    }

    @Test
    public void testsendRussia() {

        // given:
        LocalizationServiceMock localizationServiceMock = new LocalizationServiceMock();
        localizationServiceMock.setMessage("Привет");
        GeoServiceMock geoServiceMock = new GeoServiceMock();
        geoServiceMock.setLocation(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        MessageSenderImpl sut = new MessageSenderImpl(geoServiceMock,localizationServiceMock);
        Map<String,String> haders = new HashMap<>();
        haders.put(MessageSenderImpl.IP_ADDRESS_HEADER,"111");
        String expected = "Привет";

        // when:
        String act = sut.send(haders);

        // then:
        Assertions.assertEquals(expected,act);

    }
}
