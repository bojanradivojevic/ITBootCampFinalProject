package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    String email = "admin@admin.com";
    String password = "12345";

    @Test
    public void visitsTheLoginPage() {
        homePage.openLoginPage();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(loginPage.getUrlPage(), expectedResult);
    }

    @Test
    public void checksInputTypes() {
        homePage.openLoginPage();
        String expectedEmailType = "email";
        String expectedPasswordType = "password";
        Assert.assertEquals(loginPage.getEmailFieldType(), expectedEmailType);
        Assert.assertEquals(loginPage.getPasswordFieldType(), expectedPasswordType);
    }

    @Test
    public void displeysErrorsWhenUserDoesNotExist() {
        homePage.openLoginPage();
        loginPage.fillInTheLoginFields(faker.internet().emailAddress(), faker.internet().password());
        String expectedMessage = "User does not exists";
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(loginPage.getErrorMessageUserDoesNotExists(), expectedMessage);
        Assert.assertEquals(loginPage.getUrlPage(), expectedResult);
    }

    @Test
    public void displeysErrorsWhenPasswordIsWrong() {
        homePage.openLoginPage();
        loginPage.fillInTheLoginFields(email, faker.internet().password());
        String expectedMessage = "Wrong password";
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(loginPage.getErrorMessageWrongPassword(), expectedMessage);
        Assert.assertEquals(loginPage.getUrlPage(), expectedResult);
    }

    @Test
    public void login() {
        homePage.openLoginPage();
        loginPage.fillInTheLoginFields(email, password);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/h1")));
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        Assert.assertEquals(loginPage.getUrlPage(), expectedResult);
        homePage.logout();
    }

    @Test
    public void logout() {
        homePage.openLoginPage();
        loginPage.fillInTheLoginFields(email, password);
        Assert.assertTrue(homePage.logoutButtonIsVisible());
        homePage.logout();

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(loginPage.getUrlPage(), expectedResult);
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(loginPage.getUrlPage(), expectedUrl);
    }
}
