package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasePage {

    @FindBy(className = "success")
    private WebElement messageProfileSavedSuccessfuly;

    @FindBy(className = "btnProfile")
    private WebElement profileButton;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "phone")
    private WebElement phoneNumber;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "urlTwitter")
    private WebElement twitterUrl;

    @FindBy(id = "urlGitHub")
    private WebElement gitHubUrl;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    public void fillTheProfileForm(String phone, String city, String country) {
        //this.phoneNumber.clear();
        //this.country.clear();
        this.phoneNumber.click();
        this.phoneNumber.sendKeys(phone);
        this.country.sendKeys(country);
        this.city.sendKeys(Keys.SPACE);
        this.city.sendKeys(Keys.CONTROL + "a");
        this.city.sendKeys(city);
        this.city.sendKeys(Keys.ARROW_DOWN);
        this.city.sendKeys(Keys.ENTER);
        this.saveButton.click();
    }

    public void selectProfileButton() {
        this.profileButton.click();
    }

    public boolean getMessageProfileSavedSuccessfuly() {
        return this.messageProfileSavedSuccessfuly.getText().contains("Profile saved successfuly");
    }

    public boolean geInputFieldsTypeProfileForm(String nameValueAtt, String phoneValueAtt, String cityValueAtt,
                                                String countryValueAtt, String twitterValueAtt, String gitHubValueAtt) {
        this.name.getAttribute("type").equals(nameValueAtt);
        this.phoneNumber.getAttribute("type").equals(phoneValueAtt);
        this.city.getAttribute("type").equals(cityValueAtt);
        this.country.getAttribute("type").equals(countryValueAtt);
        this.twitterUrl.getAttribute("type").equals(twitterValueAtt);
        this.gitHubUrl.getAttribute("type").equals(gitHubValueAtt);

        return true;
    }

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
