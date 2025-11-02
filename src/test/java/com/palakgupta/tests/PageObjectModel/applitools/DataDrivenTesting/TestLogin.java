package com.palakgupta.tests.PageObjectModel.applitools.DataDrivenTesting;

import com.palakgupta.base.CommonToAllTests;
import com.palakgupta.driver.DriverManager;
import com.palakgupta.pages.PageObjectModel.applitools.HomePage;
import com.palakgupta.pages.PageObjectModel.applitools.LoginPage;
import com.palakgupta.util.DataProviderUtils;
import com.palakgupta.util.PropertiesReader;
import com.palakgupta.util.UtilExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLogin extends CommonToAllTests {

    @Owner("Palak Gupta")
    @Description("Verify User is able to login")
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void test_Login(String username, String password){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        HomePage homePage=loginPage.signIn(PropertiesReader.readKey("ACMEDemo"), username,password);
        Assert.assertTrue(homePage.getHomePageLogo());

    }



}
