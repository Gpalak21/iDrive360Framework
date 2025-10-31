package com.palakgupta.util;

import io.qameta.allure.internal.shadowed.jackson.databind.annotation.JsonAppend;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readKey(String key){
        Properties p;
        String user_dir=System.getProperty("user.dir");
        String file_path=user_dir+"/src/main/resources/data.properties";

        try {
            FileInputStream file = new FileInputStream(file_path);
            p=new Properties();
            p.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return p.getProperty(key);
    }
}
