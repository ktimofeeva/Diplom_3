import static org.hamcrest.CoreMatchers.startsWith;

import date.User;
import date.UserGenerator;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.RegistrationPage;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {

    private RegistrationPage registrationPage;
    private User user;

    @Before
    public void setUp(){
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
    }

    @Test
    public void successRegistrationTest(){
        user = UserGenerator.getDefault();
        registrationPage.fillInRegistrationForm(user.getName(),user.getEmail(),user.getPassword());
        registrationPage.clickRegistrationButton();
        MatcherAssert.assertThat(registrationPage.returnTextAfterSuccessRegistration(), startsWith("Вход"));
    }

    @Test
    public void passwordErrorTest(){
        user = UserGenerator.getPasswordError();
        registrationPage.fillInRegistrationForm(user.getName(),user.getEmail(),user.getPassword());
        registrationPage.clickRegistrationButton();
        MatcherAssert.assertThat(registrationPage.returnTextAfterFailedRegistration(),startsWith("Некорректный пароль"));
    }
}
