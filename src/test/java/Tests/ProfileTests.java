package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTests {

    @Test
    private void editsProfile() {
        homePage.openSignupPage();
        signupPage.fillInTheSignupFields(faker.name().name(), faker.internet().emailAddress(), "123456", "123456");
        profilePage.selectProfileButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        profilePage.fillTheProfileForm(faker.phoneNumber().phoneNumber(), "Chicago", faker.address().country());
        String expectedMessage = "Profile saved successfuly";

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(profilePage.getMessageProfileSavedSuccessfuly());
        Assert.assertTrue(profilePage.geInputFieldsTypeProfileForm("text", "tel", "text",
                "text", "url", "url"));


        homePage.logout();
    }
}
