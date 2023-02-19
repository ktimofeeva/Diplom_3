package date;
import org.apache.commons.lang3.RandomStringUtils;
import site.nomoreparties.stellarburgers.pageobjects.RegistrationPage;

public class UserGenerator {

    public static User getDefault(){
        final String name = RandomStringUtils.randomAlphabetic(10);
        final String email = RandomStringUtils.randomAlphabetic(10)+"@yandex.ru";
        final String password = RandomStringUtils.randomAlphabetic(10);

        return new User(name, email, password);
    }

    public static User getPasswordError(){
        final String name = RandomStringUtils.randomAlphabetic(10);
        final String email = RandomStringUtils.randomAlphabetic(10)+"@yandex.ru";
        final String password = RandomStringUtils.randomAlphabetic(5);

        return new User(name, email, password);
    }
}
