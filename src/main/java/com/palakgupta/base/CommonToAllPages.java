package com.palakgupta.base;

import com.palakgupta.util.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.palakgupta.driver.DriverManager.getDriver;

public class CommonToAllPages {

    public void openIDriveUrl(){
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void clickElement(By element){
        getDriver().findElement(element).click();
    }

    public void enterElement(By element, String data){
        getDriver().findElement(element).sendKeys(data);
    }

    public void selectDropdown(By dropdown,String text){
        WebElement element = getDriver().findElement(dropdown);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public String getText(By element){
        return getDriver().findElement(element).getText();
    }
}
