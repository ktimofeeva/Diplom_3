import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.LoginPage;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.startsWith;

public class ConstructorTest {

    private LoginPage loginPage;
    private MainPage mainPage;

    @Before
    public void SetUp(){
        loginPage = open("https://stellarburgers.nomoreparties.site/login",LoginPage.class);
        loginPage.fillInLoginForm("kristim@yandex.ru","kristim");
        loginPage.clickButtonLogin();
        mainPage = page(MainPage.class);
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void transitionOnRolls(){
        mainPage.clickButtonSauces();
        mainPage.clickButtonRolls();
        MatcherAssert.assertThat(mainPage.returnInscriptionRolls(),startsWith("Булки"));
    }

    @Test
    public void transitionOnSauces(){
        mainPage.clickButtonSauces();
        MatcherAssert.assertThat(mainPage.returnInscriptionSauces(),startsWith("Соусы"));
    }

    @Test
    public void transitionOnToppings(){
        mainPage.clickButtonToppings();
        MatcherAssert.assertThat(mainPage.returnInscriptionToppings(),startsWith("Начинки"));
    }
}
