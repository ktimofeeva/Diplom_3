import date.User;
import date.UserGenerator;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.startsWith;

public class RegistrationTest {

    private RegistrationPage registrationPage;
    private User user;

    @Before
    public void setUp() {
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
    }

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    public void successRegistrationTest() {
        user = UserGenerator.getDefault();
        registrationPage.fillInRegistrationForm(user.getName(), user.getEmail(), user.getPassword());
        registrationPage.clickRegistrationButton();
        MatcherAssert.assertThat(registrationPage.returnTextAfterSuccessRegistration(), startsWith("Вход"));
    }

    @Test
    @DisplayName("Регистрация пользователя с некорректным паролем")
    public void passwordErrorTest() {
        user = UserGenerator.getPasswordError();
        registrationPage.fillInRegistrationForm(user.getName(), user.getEmail(), user.getPassword());
        registrationPage.clickRegistrationButton();
        comparingTextButtonWithExpectedResult("Некорректный пароль");
    }

    @Step("Comparing text button with the expected result")
    public void comparingTextButtonWithExpectedResult(String text){
        MatcherAssert.assertThat(registrationPage.returnTextAfterFailedRegistration(), startsWith(text));
    }
}
