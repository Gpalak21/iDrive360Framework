package com.palakgupta.tests.PageObjectModel.applitools;

import com.palakgupta.base.CommonToAllTests;
import com.palakgupta.driver.DriverManager;
import com.palakgupta.pages.PageObjectModel.applitools.HomePage;
import com.palakgupta.pages.PageObjectModel.applitools.LoginPage;
import com.palakgupta.util.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePageTable extends CommonToAllTests {

    @Owner("Palak Gupta")
    @Description("Get the Total Amount From Table")
    @Test
    public void getTotalAmount(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        HomePage homePage=loginPage.signIn(PropertiesReader.readKey("ACMEDemo"),PropertiesReader.readKey("ACMEUser"),PropertiesReader.readKey("ACMEpass"));
        double totalAmount=homePage.getTableData();
        System.out.println("Total Amount is: "+totalAmount);
        double expectedAmount=Double.parseDouble(PropertiesReader.readKey("totalAmount"));
        Assert.assertEquals(totalAmount,expectedAmount,0.01);
    }
}
