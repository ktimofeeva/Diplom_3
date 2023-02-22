package site.nomoreparties.stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {
    //локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement buttonConstructor;

    //локатор для логотипа "Stellar Burgers"
    @FindBy(how = How.XPATH, using = ".//div[@class = 'AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    //локатор кнопки "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement buttonExit;

    //локатор надписи "Профиль"
    @FindBy(how = How.XPATH, using = ".//a[@href='/account/profile']")
    private SelenideElement inscriptionProfile;

    //метод для нажатия кнопки конструктор
    public void clickButtonConstructor() {
        buttonConstructor.click();
    }

    //метод для клика на логотип
    public void clickLogo() {
        logo.click();
    }

    //метод нажатия кнопки "Выход"
    public void clickButtonExit() {
        buttonExit.click();
    }

    //метод, возвращающий надпись "Профиль"
    public String returnInscriptionProfile() {
        return inscriptionProfile.getText();
    }
}
