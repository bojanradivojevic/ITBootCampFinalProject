package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdminCitiesPage extends BasePage {

    @FindBy(className = "btnAdmin")
    private WebElement adminMenuButton;

    @FindBy(className = "btnAdminCities")
    private WebElement citiesButton;

    @FindBy(className = "btnLogout")
    private WebElement logout;

    @FindBy(className = "btnNewItem")
    private WebElement newItemButton;

    @FindBy(id = "name")
    private WebElement nameOfTheNewCity;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageSavedSuccessfully;

    public void clickAdminMenuButton() {
        this.adminMenuButton.click();
    }

    public void selectCities() {
        this.citiesButton.click();
    }

    public void logout() {
        this.logout.click();
    }

    public void createNewItem(String nameOfTheNewCity) {
        this.newItemButton.click();
        this.nameOfTheNewCity.click();
        this.nameOfTheNewCity.sendKeys(nameOfTheNewCity);
        this.saveButton.click();
    }

    public boolean getMessageSavedSuccessfully() {
        return this.messageSavedSuccessfully.getText().contains("Saved successfully");
    }

    public AdminCitiesPage(WebDriver driver) {
        super(driver);
    }
}
