package by.itacademy.module;

import java.util.*;

public class Locales {
    private Map<String, Locale> locales = new HashMap<>();

    {
        locales.put("English", new Locale("en"));
        locales.put("Русский", new Locale("ru"));
    }

    public List<String> getKeys() {
        return new ArrayList<>(locales.keySet());
    }

    public Locale getValue(int choice) {
        String key = getKey(choice);
        return locales.get(key);
    }

    private String getKey(int choice) {
        return getKeys().get(choice);
    }
}