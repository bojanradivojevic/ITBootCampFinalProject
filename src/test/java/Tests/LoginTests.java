package Tests;

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
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();
        loginPage.fillInTheLoginFields(fakeEmail, fakePassword);
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
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
