package com.palakgupta.tests.PageObjectModel.DemoQA;

import com.palakgupta.base.CommonToAllTests;
import com.palakgupta.driver.DriverManager;
import com.palakgupta.pages.PageObjectModel.DemoQA.HomePage;
import com.palakgupta.util.DataProviderUtils;
import com.palakgupta.util.PropertiesReader;
import com.palakgupta.util.UtilExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class TC002 extends CommonToAllTests {

    @Owner("Palak Gupta")
    @Description("Verify Details After Adding")
    @Test
    public void verifyDetailsAfterAdding(){
        HomePage homePage = new HomePage(DriverManager.getDriver());

        Object[][] data = UtilExcel.getTestDataFromExcel("sheet1");
        for(Object[] row: data) {
                String fname = row[0].toString();
                String lname = row[1].toString();
            String email = row[2].toString();
            String age = row[3].toString();
            String salary = row[4].toString();
            String department = row[5].toString();


            homePage.addNewRow(PropertiesReader.readKey("DEMOQAUrl"), fname, lname, email, age, salary, department);
        }
    }

}
