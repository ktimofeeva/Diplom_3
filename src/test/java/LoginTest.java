import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.ForgotPassword;
import site.nomoreparties.stellarburgers.pageobjects.LoginPage;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.startsWith;

public class LoginTest {

    private MainPage mainPage;

    @Before
    public void SetUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Авторизация через кнопку в форме регистрации")
    public void loginFromButtonOnRegistrationPage() {
        RegistrationPage registrationPage =
                open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.clickButtonLogin();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillInLoginForm("kristim@yandex.ru", "kristim");
        loginPage.clickButtonLogin();
        MatcherAssert.assertThat(mainPage.returnTextButtonPlaceAnOrder(), startsWith("Оформить заказ"));
    }

    @Test
    @DisplayName("Авторизация по кнопке Войти в аккаунт на главной странице")
    public void loginFromButtonLoginInAccountOnMainPage() {
        mainPage.clickButtonSignIn();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillInLoginForm("kristim@yandex.ru", "kristim");
        loginPage.clickButtonLogin();
        MatcherAssert.assertThat(mainPage.returnTextButtonPlaceAnOrder(), startsWith("Оформить заказ"));
    }

    @Test
    @DisplayName("Авторизация по кнопке Личный кабинет")
    public void loginFromButtonAccountOnMainPage() {
        mainPage.clickButtonAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillInLoginForm("kristim@yandex.ru", "kristim");
        loginPage.clickButtonLogin();
        MatcherAssert.assertThat(mainPage.returnTextButtonPlaceAnOrder(), startsWith("Оформить заказ"));
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromButtonLoginOnForgotPasswordPage() {
        ForgotPassword forgotPassword =
                open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPassword.class);
        forgotPassword.clickButtonLogin();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillInLoginForm("kristim@yandex.ru", "kristim");
        loginPage.clickButtonLogin();
        MatcherAssert.assertThat(mainPage.returnTextButtonPlaceAnOrder(), startsWith("Оформить заказ"));
    }
}
