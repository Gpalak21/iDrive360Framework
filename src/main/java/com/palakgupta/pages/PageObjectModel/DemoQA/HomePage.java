package com.palakgupta.pages.PageObjectModel.DemoQA;

import com.palakgupta.base.CommonToAllPages;
import com.palakgupta.util.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends CommonToAllPages {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By editButtonsvg =By.xpath("//span[@id='edit-record-3']//*[name()='svg']");
    private By firstName=By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By age = By.id("age");
    private By salary = By.id("salary");
    private By department = By.id("department");
    private By submitButton = By.id("submit");
    //private By updatedValue = By.xpath("//div[@role='gridcell' and normalize-space(text())='"+']/ancestor::div[@role='row']//div[@role='gridcell']");
    private By addButton = By.id("addNewRecordButton");

    private By getUpdatedRow(String emailText){
        return By.xpath("//div[@role='gridcell' and normalize-space(text())='"+emailText+"']/ancestor::div[@role='row']//div[@role='gridcell']");
    }

    public void clickOnEditButton(String url, String fname, String lname, String emailText, String ageText, String salaryText, String departmentText){
        openUrl(url);
        WaitHelpers.checkForVisibilityOfElement(10,editButtonsvg);
        scrollIntoView(editButtonsvg);
        clickElement(editButtonsvg);
        WaitHelpers.checkForVisibilityOfElement(10,firstName);
        enterElement(firstName,fname);
        enterElement(lastName,lname);
        enterElement(email, emailText);
        enterElement(age, ageText);
        enterElement(salary, salaryText);
        enterElement(department, departmentText);
        clickElement(submitButton);
    }

    public String[] getEditedRecord(String emailText){
        By updatedRow = getUpdatedRow(emailText);
        List<WebElement> cell = getcells(updatedRow);
        int col = getColSize(updatedRow);
        String[] values = new String[col];
        for(int i=0;i<col;i++){
           values[i] =cell.get(i).getText();
        }
        return values;

    }

        public void addNewRow(String url, String fname, String lname, String ageText, String emailText, String salaryText, String departmentText){
            openUrl(url);
            WaitHelpers.checkForVisibilityOfElement(10,addButton);
            clickElement(addButton);
            enterElement(firstName,fname);
            enterElement(lastName,lname);
            enterElement(email, emailText);
            enterElement(age, ageText);
            if (salaryText.contains(".")) {
                salaryText = salaryText.split("\\.")[0];
            }
            enterElement(salary, salaryText);
            enterElement(department, departmentText);
            clickElement(submitButton);

        }
}
