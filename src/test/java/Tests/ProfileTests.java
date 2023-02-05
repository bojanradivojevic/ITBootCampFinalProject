package Tests;



import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTests {

    @Test
    public void editsProfile() {
        homePage.openSignupPage();
        signupPage.fillInTheSignupFields(faker.name().name(), faker.internet().emailAddress(), "123456", "123456");
        profilePage.selectProfileButton();
        profilePage.fillTheProfileForm(faker.phoneNumber().phoneNumber(), "Chicago", faker.address().country());

        Assert.assertTrue(profilePage.getMessageProfileSavedSuccessfuly());
        Assert.assertTrue(profilePage.geInputFieldsTypeProfileForm("text", "tel", "text",
                "text", "url", "url"));
        homePage.logout();
    }
}
