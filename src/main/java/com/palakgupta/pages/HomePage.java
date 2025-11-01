package com.palakgupta.pages;

import com.palakgupta.base.CommonToAllPages;
import com.palakgupta.util.PropertiesReader;
import com.palakgupta.util.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonToAllPages {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        WaitHelpers.checkForVisibilityOfElement(10,upgradeNow_button);
    }

    //private By addDevice_button = By.xpath("//a[contains(text(),'Add Devices')]");
    private By upgradeNow_button = By.xpath("//button[text()='Upgrade Now!']");

    public MyAccountPage clickUpgradeNowButton(){
        clickElement(upgradeNow_button);
        return new MyAccountPage(driver);
    }


}
