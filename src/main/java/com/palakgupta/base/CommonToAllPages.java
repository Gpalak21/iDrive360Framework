package com.palakgupta.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.palakgupta.driver.DriverManager.driver;
import static com.palakgupta.driver.DriverManager.getDriver;

public class CommonToAllPages {

    public void openUrl(String url){
        getDriver().get(url);
    }

    public void clickElement(By element){
        getDriver().findElement(element).click();
    }

    public void enterElement(By element, String data){
        getDriver().findElement(element).sendKeys(data);
    }

    public void selectDropdown(By dropdown,String text){
        WebElement element = getDriver().findElement(dropdown);
        try {
            // normalize-space trims leading/trailing and merges multiple spaces
            element.findElement(By.xpath(".//option[normalize-space(text())='" + text.trim() + "']")).click();
        } catch (Exception e) {
            // fallback for non-standard dropdowns
            Select select = new Select(element);
            for (WebElement opt : select.getOptions()) {
                if (opt.getText().replace("\u00A0", " ").trim().equalsIgnoreCase(text.trim())) {
                    opt.click();
                    return;
                }
            }
            throw new RuntimeException("Option not found: " + text);
        }

    }

    public String getText(By element){
        return getDriver().findElement(element).getText();
    }

    public String getText(String element){
        return getDriver().findElement(By.xpath(element)).getText();
    }

    public void scrollIntoView(By element){
        WebElement webElement = getDriver().findElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",webElement);
    }

    public void getDriverToDefaultContent(){
        getDriver().switchTo().defaultContent();
    }

    public void switchToIframe(By frame){
        WebElement iframe = getDriver().findElement(frame);
        getDriver().switchTo().frame(iframe);
    }

    public int getRowSize(By row){
       return getDriver().findElements(row).size();
    }

    public int getColSize(By cols){
        return getDriver().findElements(cols).size();
    }

    public String getCellText(String firstPart, int rowIndex, String secondPart, String thirdPart){
        String dynamic_path = firstPart + rowIndex + secondPart + 5 + thirdPart;
        //System.out.println("Fetching cell: "+dynamic_path);
        return getText(By.xpath(dynamic_path)).trim();
    }

    public boolean isDisplayed(By logo){
        WebElement element = getDriver().findElement(logo);
        return element.isDisplayed();
    }
}
