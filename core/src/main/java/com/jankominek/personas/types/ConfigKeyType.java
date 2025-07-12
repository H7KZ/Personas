package com.jankominek.personas.types;

public enum ConfigKeyType {
    LOCALES("locales"),

    ENABLED("enabled"),

    LOCALE("locale"),
    ;

    private final String key;

    ConfigKeyType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
