package com.java.learn.java8.time;

import java.util.ListResourceBundle;

// Resource Bundle as Java Class
//      extends ListResourceBundle
//      override: protected Object[][] getContents()
public class Bundle extends ListResourceBundle{
    
    protected Object[][] getContents(){
        return new Object[][]{
            {"key1", "1"},
            {"key2", "2"},
            {"key3", "3"}
        };
    }

}
