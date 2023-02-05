package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTests {

    @Test
    public void setLocaleToEs() {
        localePage.selectEs();
        String expectedText = "Página de aterrizaje";
        Assert.assertEquals(localePage.getHeader(), expectedText);
    }

    @Test(dependsOnMethods = "setLocaleToEs")
    public void setLocaleToEn() {
        localePage.selectEn();
        String expectedText = "Landing";
        Assert.assertEquals(localePage.getHeader(), expectedText);
    }

    @Test
    public void setLocaleToFr() {
        localePage.selectFr();
        String expectedText = "Page d'atterrissage";
        Assert.assertEquals(localePage.getHeader(), expectedText);
    }
}
