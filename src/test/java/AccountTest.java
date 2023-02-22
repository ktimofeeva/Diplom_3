import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.LoginPage;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.ProfilePage;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.startsWith;

public class AccountTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private ProfilePage profilePage;

    @Before
    public void SetUp() {
        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.fillInLoginForm("kristim@yandex.ru", "kristim");
        loginPage.clickButtonLogin();
        mainPage = page(MainPage.class);
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Переход с главной страницы в личный кабинет")
    public void transitionFromMainPageToProfilePage() {
        mainPage.clickButtonAccount();
        profilePage = page(ProfilePage.class);
        MatcherAssert.assertThat(profilePage.returnInscriptionProfile(), startsWith("Профиль"));
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на Конструктор")
    public void transitionFromAccountToСonstructor() {
        mainPage.clickButtonAccount();
        profilePage = page(ProfilePage.class);
        profilePage.clickButtonConstructor();
        mainPage = page(MainPage.class);
        MatcherAssert.assertThat(mainPage.returnBurgerConstructorTitle(), startsWith("Соберите бургер"));
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void transitionFromAccountToLogo() {
        mainPage.clickButtonAccount();
        profilePage = page(ProfilePage.class);
        profilePage.clickLogo();
        mainPage = page(MainPage.class);
        MatcherAssert.assertThat(mainPage.returnBurgerConstructorTitle(), startsWith("Соберите бургер"));
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void exitFromAccount() {
        mainPage.clickButtonAccount();
        profilePage = page(ProfilePage.class);
        profilePage.clickButtonExit();
        loginPage = page(LoginPage.class);
        MatcherAssert.assertThat(loginPage.returnInscriptionEntrance(), startsWith("Вход"));
    }
}
