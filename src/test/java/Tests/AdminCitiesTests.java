package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTests {

    @Test
    public void VisitsTheAdminCitiesPageAndListCities() {
           homePage.openLoginPage();
           loginPage.fillInTheLoginFields("admin@admin.com", "12345");
           adminCitiesPage.clickAdminMenuButton();
           adminCitiesPage.selectCities();
           String expectedResult = "https://vue-demo.daniel-avellaneda.com/admin/cities";


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        adminCitiesPage.searchCity(newCity);
        adminCitiesPage.deleteCity();

        // expectedResult: String newCity is in the list of cities.
        Assert.assertTrue(adminCitiesPage.getCitiesListElement(newCity));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // expectedMessage = "Deleted successfully";
        Assert.assertTrue(adminCitiesPage.getMessageDeletedSuccessfully());
        adminCitiesPage.logout();
    }
}
