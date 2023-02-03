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
        String expectedMessage = "Saved successfully";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(adminCitiesPage.getMessageSavedSuccessfully());
        adminCitiesPage.logout();
    }
}
