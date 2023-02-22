package site.nomoreparties.stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //локатор поля для введения Email
    @FindBy(how = How.XPATH, using = "(.//input[@name='name'])")
    private SelenideElement fieldEnterEmail;

    //локатор поля для введения Пароля
    @FindBy(how = How.XPATH, using = "(.//input[@name='Пароль'])")
    private SelenideElement fieldEnterPassword;

    //локатор для кнопки "Войти"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement buttonLogin;

    //локатор для кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement buttonAccount;

    //локатор надписи "Вход"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement inscriptionEntrance;

    //метод заполнения поля Email
    public void fillInTheEmailField(String email) {
        fieldEnterEmail.setValue(email);
    }

    //метод заполнения поля Пароль
    public void fillInThePasswordField(String password) {
        fieldEnterPassword.setValue(password);
    }

    //метод для нажатия кнопки "Войти"
    public void clickButtonLogin() {
        buttonLogin.click();
    }

    //метод для заполнения формы входа
    public void fillInLoginForm(String email, String password) {
        fillInTheEmailField(email);
        fillInThePasswordField(password);
    }

    //метод, вохвращающий надпись "Вход"
    public String returnInscriptionEntrance() {
        return inscriptionEntrance.getText();
    }
}
