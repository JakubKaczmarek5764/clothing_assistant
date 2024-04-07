package com.example.clothing_assistant;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nHandler {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle bundle = ResourceBundle.getBundle("ResourceBundles.lang", locale);

    static String get(String key){
        return bundle.getString(key);
    }

}
