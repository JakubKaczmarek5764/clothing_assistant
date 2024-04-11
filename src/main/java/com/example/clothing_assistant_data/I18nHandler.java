package com.example.clothing_assistant_data;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nHandler {
    private static Locale locale = new Locale("pl", "PL");
    private static ResourceBundle bundle = ResourceBundle.getBundle("ResourceBundles.lang", locale);

    static String get(String key){
        return bundle.getString(key);
    }

}
