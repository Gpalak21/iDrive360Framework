package com.palakgupta.tests.PageObjectModel.idrive;

import com.palakgupta.base.CommonToAllTests;
import com.palakgupta.driver.DriverManager;
import com.palakgupta.pages.PageObjectModel.iDrive.LandingPage;
import com.palakgupta.pages.PageObjectModel.iDrive.SignUpPage;
import com.palakgupta.util.PropertiesReader;
import com.palakgupta.util.TestDataManager;
import com.palakgupta.util.User;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class CreateAccountTest extends CommonToAllTests {

    @Owner("Palak gupta")
    @Description("Verify user is able to Signup")
    @Test
    public void test_SignUp(){
        User newUser = TestDataManager.getNewUser();
        LandingPage landingPage = new LandingPage(DriverManager.getDriver());
        SignUpPage signUpPage =landingPage.clickSignUp(PropertiesReader.readKey("url"));
        signUpPage.createAccount(
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getEmail(),
                newUser.getPassword(),
                newUser.getCompany(),
                newUser.getCountry(),
                newUser.getPhone()
        );
    }
}
