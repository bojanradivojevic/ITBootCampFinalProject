package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTests{

    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(loginPage.getUrlPage(), expectedUrl);
    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(loginPage.getUrlPage(), expectedUrl);
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(loginPage.getUrlPage(), expectedUrl);
    }

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(loginPage.getUrlPage(), expectedUrl);
    }

}
