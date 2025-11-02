package com.palakgupta.util;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    @DataProvider(name ="getData")
    public Object[][] getData(){
        return UtilExcel.getTestDataFromExcel("sheet1");
    }
}
