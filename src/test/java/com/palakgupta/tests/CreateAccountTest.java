package com.palakgupta.tests;

import com.palakgupta.base.CommonToAllPages;
import com.palakgupta.base.CommonToAllTests;
import com.palakgupta.driver.DriverManager;
import com.palakgupta.pages.LandingPage;
import com.palakgupta.pages.SignUpPage;
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
        SignUpPage signUpPage =landingPage.clickSignUp();
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
