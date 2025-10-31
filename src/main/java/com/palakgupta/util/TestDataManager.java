package com.palakgupta.util;

import io.qameta.allure.internal.shadowed.jackson.databind.annotation.JsonAppend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDataManager {

    public static String generateUniqueEmail(){
        String timestamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return PropertiesReader.readKey("emailPrefix")+timestamp+PropertiesReader.readKey("emailDomain");
    }

    public static User getNewUser(){
        User user = new User();
        user.setFirstName(PropertiesReader.readKey("firstName"));
        user.setLastName(PropertiesReader.readKey("lastName"));
        user.setEmail(generateUniqueEmail());
        user.setPassword(PropertiesReader.readKey("password"));
        user.setCompany(PropertiesReader.readKey("companyName"));
        user.setCountry(PropertiesReader.readKey("countryName"));
        user.setPhone(PropertiesReader.readKey("phoneNumber"));
        return user;
    }
}
