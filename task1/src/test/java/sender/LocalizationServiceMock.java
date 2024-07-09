package sender;

import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceMock implements LocalizationService {
    private String message = "Welcome";
    @Override
    public String locale(Country country) {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;

    }
}
