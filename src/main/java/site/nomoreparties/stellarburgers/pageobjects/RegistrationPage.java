package site.nomoreparties.stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    //локатор поля для введения Имя
    @FindBy(how = How.XPATH, using = "(.//input[@name='name'])[1]")
    private SelenideElement fieldEnterName;

    //локатор поля для введения Email
    @FindBy(how = How.XPATH, using = "(.//input[@name='name'])[2]")
    private SelenideElement fieldEnterEmail;

    //локатор поля для введения Пароля
    @FindBy(how = How.XPATH, using = "(.//input[@name='Пароль'])")
    private SelenideElement fieldEnterPassword;

    //локатор для кнопки "Зарегистрироваться"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement registrationButton;

    //локатор надписи "Вход" при успешной регистрации
    @FindBy(how = How.XPATH, using = ".//*[text()='Вход']")
    private SelenideElement inscriptionEntrance;

    //локатор надписи при вводе в поле пароль значения меньше 6 символов
    @FindBy(how = How.XPATH, using = ".//*[text()='Некорректный пароль']")
    private SelenideElement inscriptionIncorrectPassword;

    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement buttonLogin;

    //метод для нажатия кнопки "Зарегистрироваться"
    public void clickRegistrationButton() {
        registrationButton.click();
    }

    //метод заполнения поля Имя
    public void fillInTheNameField(String name) {
        fieldEnterName.setValue(name);
    }

    //метод заполнения поля Email
    public void fillInTheEmailField(String email) {
        fieldEnterEmail.setValue(email);
    }

    //метод заполнения поля Пароль
    public void fillInThePasswordField(String password) {
        fieldEnterPassword.setValue(password);
    }

    //метод, возвращающий текст после успешной регистрации
    public String returnTextAfterSuccessRegistration() {
        return inscriptionEntrance.getText();
    }

    //метод, возвращающий текст при введение пароля некорректной длины
    public String returnTextAfterFailedRegistration() {
        return inscriptionIncorrectPassword.getText();
    }

    //метод для заполнения формы регистрации
    public void fillInRegistrationForm(String name, String email, String password) {
        fillInTheNameField(name);
        fillInTheEmailField(email);
        fillInThePasswordField(password);
    }

    //метод нажатия кнопки "Войти"
    public void clickButtonLogin() {
        buttonLogin.click();
    }
}
