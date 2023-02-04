package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageDeletedSuccessfully;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr")
    private WebElement citiesList;

    @FindBy(xpath = "//*[@id=\"edit\"]")
    private WebElement editButton;

    @FindBy(xpath = "//*[@id=\"delete\"]")
    private WebElement deleteButton;

    @FindBy(id = "search")
    private WebElement searchInputField;

    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement deleteConfirmation;

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
    public boolean getMessageDeletedSuccessfully() {
        return this.messageDeletedSuccessfully.getText().contains("Deleted successfully");
    }
    public void editCity(String newCity) {
        this.editButton.click();
        this.nameOfTheNewCity.sendKeys(Keys.SPACE);
        this.nameOfTheNewCity.sendKeys(Keys.CONTROL + "a");
        this.nameOfTheNewCity.sendKeys(newCity);
        this.nameOfTheNewCity.sendKeys(Keys.ARROW_DOWN);
        this.saveButton.click();
    }

    public void searchCity(String city) {
        this.searchInputField.sendKeys(Keys.CONTROL + "a");
        this.searchInputField.sendKeys(city);
        this.searchInputField.sendKeys(Keys.ENTER);
    }

    public void deleteCity() {
        this.deleteButton.click();
        this.deleteConfirmation.click();
    }

    public boolean getCitiesListElement(String city) {
        List<WebElement> cities = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr"));
        for (int i = 0; i < cities.size(); i++) {
            cities.get(i).getText().contains(city);
        }
        return true;
    }
    public AdminCitiesPage(WebDriver driver) {
        super(driver);
    }
}
