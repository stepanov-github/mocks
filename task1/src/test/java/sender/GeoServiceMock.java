package sender;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class GeoServiceMock implements GeoService {
    Location location = new Location("New York", Country.USA, " 10th Avenue", 32);


    @Override
    public Location byIp(String ip) {
        return location;

    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return null;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
