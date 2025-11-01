package com.palakgupta.tests.PageObjectModel.applitools;

import com.palakgupta.base.CommonToAllTests;
import com.palakgupta.driver.DriverManager;
import com.palakgupta.pages.PageObjectModel.applitools.LoginPage;
import com.palakgupta.util.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestLogin extends CommonToAllTests {

    @Owner("Palak Gupta")
    @Description("Verify User is able to login")
    @Test
    public void test_Login(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.signIn(
                PropertiesReader.readKey("ACMEDemo"),
                PropertiesReader.readKey("ACMEUser"),
                PropertiesReader.readKey("ACMEpass")
        );
    }
}
