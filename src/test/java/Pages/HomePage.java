package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span")
    private WebElement loginMenuButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")
    private WebElement logoutMenuButton;

    public void openLoginPage() {
        this.loginMenuButton.click();
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
