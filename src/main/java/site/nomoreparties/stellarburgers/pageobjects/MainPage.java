package site.nomoreparties.stellarburgers.pageobjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    //локатор текста "Соберите бургер"
    @FindBy(how = How.XPATH, using = ".//h1[@class='text text_type_main-large mb-5 mt-10']")
    private SelenideElement burgerСonstructor;

    //локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement buttonPlaceAnOrder;

    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement buttonSignIn;

    //локатор кнопки "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement buttonAccount;

    //локатор для логотипа "Stellar Burgers"
    @FindBy(how = How.XPATH, using = "//div[@class = 'AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    //локатор кнопки "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement buttonRolls;

    //локатор кнопки "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement buttonSauces;

    //локатор кнопки "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement buttonToppings;

    //локатор заголовка "Булки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement  inscriptionRolls;

    //локатор заголовка "Соусы"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement  inscriptionSauces;

    //локатор заголовка "Начинки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement  inscriptionToppings;


    //метод, возвращающий текст кнопки для оформления заказа
    public String returnTextButtonPlaceAnOrder(){
        return buttonPlaceAnOrder.getText();
    }

    //метод нажатия кнопки "Войти в аккаунт"
    public void clickButtonSignIn(){
        buttonSignIn.click();
    }

    //метод нажатия кнопки "Личный Кабинет"
    public void clickButtonAccount(){
        buttonAccount.click();
    }

    //метод для клика на логотип
    public void clickLogo(){
        logo.click();
    }

    //метод, возвращающий текст "Соберите бургер"
    public String returnBurgerConstructorTitle(){
        return burgerСonstructor.getText();
    }

    //метод нажатия кнопки "Булки"
    public void clickButtonRolls(){
        buttonRolls.click();
    }

    //метод нажатия кнопки "Соусы"
    public void clickButtonSauces(){
        buttonSauces.click();
    }

    //метод нажатия кнопки "Начинки"
    public void clickButtonToppings(){
        buttonToppings.click();
    }

    //метод, возвращающий заголовок "Булки"
    public String returnInscriptionRolls(){
        return inscriptionRolls.getText();
    }

    //метод, возвращающий заголовок "Соусы"
    public String returnInscriptionSauces(){
        return inscriptionSauces.getText();
    }

    //метод, возвращающий заголовок "Начинки"
    public String returnInscriptionToppings(){
        return inscriptionToppings.getText();
    }
}
