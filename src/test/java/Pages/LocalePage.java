package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalePage extends BasePage {

    @FindBy(className = "btnLocaleActivation")
    private WebElement localeActivationButton;

    @FindBy(className = "btnES")
    private WebElement languageEs;

    @FindBy(className = "btnEN")
    private WebElement languageEn;

    @FindBy(className = "btnFR")
    private WebElement languageFr;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement header;

    public void selectEs() {
        this.localeActivationButton.click();
        languageEs.click();
    }

    public void selectEn() {
        this.localeActivationButton.click();
        languageEn.click();
    }

    public void selectFr() {
        this.localeActivationButton.click();
        languageFr.click();
    }

    public String getHeader() {
        return header.getText();
    }

    public LocalePage(WebDriver driver) {
        super(driver);
    }
}
