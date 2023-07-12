package com.krafttech.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;
 // kod bloklarını ctrl+alt+t ile surround edebiliriz try catch vs
    static {
        try {
            // path of file which is wanted to read
            String path="configuration.properties";
            // read the file into java, using the string path
            FileInputStream input=new FileInputStream(path);
            //properties --> key,value
            properties=new Properties();
            //the value ise loaded to properties
            properties.load(input);
            input.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public static String get(String keyName){
         return properties.getProperty(keyName);
    }
}
