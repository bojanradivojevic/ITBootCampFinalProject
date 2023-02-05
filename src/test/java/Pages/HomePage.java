package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span")
    private WebElement loginMenuButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")
    private WebElement logoutMenuButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]/span")
    private WebElement signupMenuButton;

    public void openLoginPage() {
        this.loginMenuButton.click();
    }

    public void openSignupPage() {
        this.signupMenuButton.click();
    }

    public void logout() {
        this.logoutMenuButton.click();
    }

    public boolean logoutButtonIsVisible() {
        return this.logoutMenuButton.isDisplayed();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
