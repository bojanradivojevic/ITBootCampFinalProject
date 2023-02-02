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
}
