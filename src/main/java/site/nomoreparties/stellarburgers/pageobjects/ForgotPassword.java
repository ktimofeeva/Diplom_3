package site.nomoreparties.stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPassword {

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement buttonLogin;

    //метод нажатия кнопки "Войти"
    public void clickButtonLogin() {
        buttonLogin.click();
    }
}
