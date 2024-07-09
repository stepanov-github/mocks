package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTests {

    @Test
    public  void testbyIp() {

        // given:
        String ip = "96.44.183.149";
        GeoServiceImpl sut = new GeoServiceImpl();
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);

        // when:
        Location act = sut.byIp(ip);

        // then:
        Assertions.assertEquals(expected.getCity(),act.getCity());
        Assertions.assertEquals(expected.getCountry(),act.getCountry());
        Assertions.assertEquals(expected.getStreet(),act.getStreet());
        Assertions.assertEquals(expected.getBuiling(),act.getBuiling());


    }
}
