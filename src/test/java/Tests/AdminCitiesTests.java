package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTests extends BaseTests {

    @Test
    public void VisitsTheAdminCitiesPageAndListCities() {
        homePage.openLoginPage();
        loginPage.fillInTheLoginFields("admin@admin.com", "12345");
        adminCitiesPage.clickAdminMenuButton();
        adminCitiesPage.selectCities();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]")));

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        Assert.assertEquals(loginPage.getUrlPage(), expectedResult);
        adminCitiesPage.logout();
    }

    @Test
    public void createNewCity() {
        homePage.openLoginPage();
        loginPage.fillInTheLoginFields("admin@admin.com", "12345");
        adminCitiesPage.clickAdminMenuButton();
        adminCitiesPage.selectCities();
        adminCitiesPage.createNewItem(faker.address().cityName());

        // expectedMessage = "Saved successfully";
        Assert.assertTrue(adminCitiesPage.getMessageSavedSuccessfully());
        adminCitiesPage.logout();
    }

    @Test
    public void editCity() {
        String newCity = faker.address().cityName();
        homePage.openLoginPage();
        loginPage.fillInTheLoginFields("admin@admin.com", "12345");
        adminCitiesPage.clickAdminMenuButton();
        adminCitiesPage.selectCities();
        adminCitiesPage.createNewItem(newCity);
        adminCitiesPage.editCity(newCity);

        // expectedMessage = "Saved successfully";
        Assert.assertTrue(adminCitiesPage.getMessageSavedSuccessfully());
        adminCitiesPage.logout();
    }

    @Test
    public void searchCity() {
        String newCity = faker.address().cityName();
        homePage.openLoginPage();
        loginPage.fillInTheLoginFields("admin@admin.com", "12345");
        adminCitiesPage.clickAdminMenuButton();
        adminCitiesPage.selectCities();
        adminCitiesPage.createNewItem(newCity);
        adminCitiesPage.editCity(newCity);
        adminCitiesPage.searchCity(newCity);

        // expectedResult: String newCity is in the list of cities.
        Assert.assertTrue(adminCitiesPage.getCitiesListElement(newCity));
        adminCitiesPage.logout();
    }

    @Test
    public void deleteCity() {
        String newCity = faker.address().cityName();
        homePage.openLoginPage();
        loginPage.fillInTheLoginFields("admin@admin.com", "12345");
        adminCitiesPage.clickAdminMenuButton();
        adminCitiesPage.selectCities();
        adminCitiesPage.createNewItem(newCity);
        adminCitiesPage.searchCity(newCity);
        adminCitiesPage.deleteCity();

        // expectedResult: String newCity is in the list of cities.
        Assert.assertTrue(adminCitiesPage.getCitiesListElement(newCity));

        // expectedMessage = "Deleted successfully";
        Assert.assertTrue(adminCitiesPage.getMessageDeletedSuccessfully());
        adminCitiesPage.logout();
    }
}
