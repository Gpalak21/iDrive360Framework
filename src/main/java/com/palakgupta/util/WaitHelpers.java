package com.palakgupta.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.palakgupta.driver.DriverManager.getDriver;

public class WaitHelpers {

    public static void waitJVM(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkForVisibilityOfElement(int time, By element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForUrlToLoad(int time,String url){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(url));
    }
}
