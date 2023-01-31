package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement errorMessage_UserDoesNotExists;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement errorMessage_WrongPassword;

    public String getEmailFieldType() {
       return this.email.getAttribute("type");
    }

    public String getPasswordFieldType() {
        return this.password.getAttribute("type");
    }

    public String getErrorMessage_UserDoesNotExists() {
        return this.errorMessage_UserDoesNotExists.getText();
    }

    public String getErrorMessage_WrongPassword() {
        return this.errorMessage_WrongPassword.getText();
    }

    public void fillInTheLoginFields(String email, String password) {
        this.email.clear();
        this.password.clear();

        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public String getUrlPage() {
        return driver.getCurrentUrl();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}

