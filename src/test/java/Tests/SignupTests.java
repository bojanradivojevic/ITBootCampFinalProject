package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTests{

    @Test
    public void visitsTheSignupPage() {
        homePage.openSignupPage();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";
        Assert.assertEquals(loginPage.getUrlPage(), expectedResult);
    }

    @Test
    public void checksInputTypes() {
        homePage.openSignupPage();
        String expectedEmailType = "email";
        String expectedPasswordType = "password";
        String expectedConfirmPasswordType = "password";

        Assert.assertEquals(signupPage.getEmailFieldType(), expectedEmailType);
        Assert.assertEquals(signupPage.getPasswordFieldType(), expectedPasswordType);
        Assert.assertEquals(signupPage.getConfirmPasswordFieldType(), expectedConfirmPasswordType);
    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists() {
        homePage.openSignupPage();
        signupPage.fillInTheSignupFields("Test Test", "admin@admin.com", "123654", "123654");
        String expectedMessage = "E-mail already exists";
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";

        Assert.assertEquals(signupPage.getErrorMessageEmailAlreadyExists(), expectedMessage);
        Assert.assertEquals(loginPage.getUrlPage(), expectedResult);
    }

    @Test
    public void signUp() {
        homePage.openSignupPage();
        signupPage.fillInTheSignupFields("Bojan Radivojevic", faker.internet().emailAddress(), "bojan", "bojan");
        String expectedMessage = "IMPORTANT: Verify your account";

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(signupPage.getMessageVerifyYourAccount(), expectedMessage);
    }

}
