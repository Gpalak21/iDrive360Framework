package com.palakgupta.pages.PageObjectModel.applitools;

import com.palakgupta.base.CommonToAllPages;
import com.palakgupta.util.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends CommonToAllPages {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By table = By.xpath("//table[contains(@class,'table-padded')]");
    private By row = By.xpath("//table[contains(@class,'table-padded')]/tbody/tr");
    private By cols = By.xpath("//table[contains(@class,'table-padded')]/tbody/tr[1]/td[5]");
    private By logo = By.xpath("//div[normalize-space(text())='ACME']");

    public Boolean getHomePageLogo(){
        return isDisplayed(logo);
    }


    public double getTableData() {
        WaitHelpers.checkForVisibilityOfElement(10,table);
        String firstPart = "//table[contains(@class,'table-padded')]/tbody/tr[";
        String secondPart = "]/td[";
        String thirdPart = "]";
        int r=getRowSize(row);
//        System.out.println("No of rows: "+r);
        double total=0;
        for(int i=1;i<=r;i++){
            String data=getCellText(firstPart,i,secondPart,thirdPart);
            if(!data.isEmpty()){
               data= data.replace("USD","").trim();
                System.out.println(data);
                boolean isNegative=data.startsWith("-");
                data=data.replace("+","").replace("-","").replace(",","").trim();

                try {
                    double value = Double.parseDouble(data);
                    if(isNegative){
                        total= total-value;
                    }
                    else {
                        total+=value;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid value: "+data);
                }
            }

        }
        return total;
    }

}
