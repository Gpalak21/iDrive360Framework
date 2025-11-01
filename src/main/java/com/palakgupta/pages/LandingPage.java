package com.palakgupta.pages;

import com.palakgupta.base.CommonToAllPages;
import com.palakgupta.util.PropertiesReader;
import com.palakgupta.util.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends CommonToAllPages {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signUp = By.xpath("//div[@class='login_wrap']//a[text()='Sign Up']");
    private By signIn = By.xpath("//div[@class='login_wrap']//a[text()='Sign In']");


    public SignUpPage clickSignUp(){
        openIDriveUrl();
        WaitHelpers.waitForUrlToLoad(5, PropertiesReader.readKey("url"));
        clickElement(signUp);
        return new SignUpPage(driver);
    }

    public LoginPage clickSignIn(){
        openIDriveUrl();
        WaitHelpers.waitForUrlToLoad(5, PropertiesReader.readKey("url"));
        clickElement(signIn);
        return new LoginPage(driver);
    }
}
