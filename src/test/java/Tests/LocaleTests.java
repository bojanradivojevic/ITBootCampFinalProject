package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTests {

    @Test
    public void setLocaleToEs() {
        localePage.selectEs();
        String expectetText = "Página de aterrizaje";
        Assert.assertEquals(localePage.getHeader(), expectetText);
    }

    @Test(dependsOnMethods = "setLocaleToEs")
    public void setLocaleToEn() {
        localePage.selectEn();
        String expectetText = "Landing";
        Assert.assertEquals(localePage.getHeader(), expectetText);
    }

    @Test
    public void setLocaleToFr() {
        localePage.selectFr();
        String expectetText = "Page d'atterrissage";
        Assert.assertEquals(localePage.getHeader(), expectetText);
    }
}
