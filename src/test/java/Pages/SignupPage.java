package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span")
    private WebElement signMeUpButton;

    @FindBy(className = "btnClose")
    private WebElement closeButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement errorMessageEmailAlreadyExists;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement messageVerifyYourAccount;

    public String getEmailFieldType() {
        return this.email.getAttribute("type");
    }

    public String getPasswordFieldType() {
        return this.password.getAttribute("type");
    }

    public String getConfirmPasswordFieldType() {
        return this.confirmPassword.getAttribute("type");
    }

    public String getErrorMessageEmailAlreadyExists() {
        return this.errorMessageEmailAlreadyExists.getText();
    }

    public String getMessageVerifyYourAccount() {
        return this.messageVerifyYourAccount.getText();
    }

    public void fillInTheSignupFields(String name, String email, String password, String confirmPassword) {
        this.name.clear();
        this.email.clear();
        this.password.clear();
        this.confirmPassword.clear();

        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);

        this.signMeUpButton.click();
    }

    public void closeButtonClick() {
        this.closeButton.click();
    }

    public SignupPage(WebDriver driver) {
        super(driver);
    }
}
