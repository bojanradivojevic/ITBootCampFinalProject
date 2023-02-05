package Tests;

import com.sun.tracing.dtrace.DependencyClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignupTests extends BaseTests {

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

    @Test(dependsOnMethods = "visitsTheSignupPage")
    public void signUp() {
        homePage.openSignupPage();
        signupPage.fillInTheSignupFields("Bojan Radivojevic", faker.internet().emailAddress(), "bojan", "bojan");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String expectedMessage = "IMPORTANT: Verify your account";
        Assert.assertEquals(signupPage.getMessageVerifyYourAccount(), expectedMessage);

        signupPage.closeButtonClick();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/h1")));
        homePage.logout();
    }
}
