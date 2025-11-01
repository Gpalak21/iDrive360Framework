package com.palakgupta.tests.PageObjectModel.idrive;

import com.palakgupta.base.CommonToAllTests;
import com.palakgupta.driver.DriverManager;
import com.palakgupta.pages.PageObjectModel.iDrive.HomePage;
import com.palakgupta.pages.PageObjectModel.iDrive.LandingPage;
import com.palakgupta.pages.PageObjectModel.iDrive.LoginPage;
import com.palakgupta.pages.PageObjectModel.iDrive.MyAccountPage;
import com.palakgupta.util.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpgradeInvalidCardTest extends CommonToAllTests {

    @Owner("Palak Gupta")
    @Description("Verify Upgarde Using Invalid Card")
    @Test
    public void test_InvalidCardUpgrade() {
        LandingPage landingPage = new LandingPage(DriverManager.getDriver());
        LoginPage loginPage = landingPage.clickSignIn(PropertiesReader.readKey("url"));
        HomePage homePage = loginPage.signIn(PropertiesReader.readKey("email"), PropertiesReader.readKey("password"));
        MyAccountPage myAccountPage = homePage.clickUpgradeNowButton();
        String errorText = myAccountPage.upgradeAccount(
                PropertiesReader.readKey("cardNumber"),
                PropertiesReader.readKey("cardExpiry"),
                PropertiesReader.readKey("cvvNo"),
                PropertiesReader.readKey("billingAddress"),
                PropertiesReader.readKey("countryDropdown"),
                PropertiesReader.readKey("stateDropdown"),
                PropertiesReader.readKey("postalCode")
        );

        Assert.assertEquals(errorText,PropertiesReader.readKey("invalidCardError"));
    }
}
