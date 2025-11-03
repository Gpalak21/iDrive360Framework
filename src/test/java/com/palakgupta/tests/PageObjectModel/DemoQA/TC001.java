package com.palakgupta.tests.PageObjectModel.DemoQA;

import com.palakgupta.base.CommonToAllTests;
import com.palakgupta.driver.DriverManager;
import com.palakgupta.pages.PageObjectModel.DemoQA.HomePage;
import com.palakgupta.util.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001 extends CommonToAllTests {

    @Owner("Palak Gupta")
    @Description("Verify user is able to edit the details")
    @Test
    public void verifyUserDetailsAfterEdit(){
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnEditButton(PropertiesReader.readKey("DEMOQAUrl"),
                PropertiesReader.readKey("firstname"),
                PropertiesReader.readKey("DEMOQAlastName"),
                PropertiesReader.readKey("DEMOQAemail"),
                PropertiesReader.readKey("age"),
                PropertiesReader.readKey("salary"),
                PropertiesReader.readKey("department"));

        String[] actualData = homePage.getEditedRecord(PropertiesReader.readKey("DEMOQAemail"));
        Assert.assertEquals(actualData[0], PropertiesReader.readKey("firstname"));
        Assert.assertEquals(actualData[1], PropertiesReader.readKey("DEMOQAlastName"));
        Assert.assertEquals(actualData[2], PropertiesReader.readKey("DEMOQAemail"));
        Assert.assertEquals(actualData[3], PropertiesReader.readKey("age"));
        Assert.assertEquals(actualData[4], PropertiesReader.readKey("salary"));
        Assert.assertEquals(actualData[5], PropertiesReader.readKey("department"));
    }
}
