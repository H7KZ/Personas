package com.jankominek.personas.types;

public enum I18nKeyType {
    // i18n messages
    PREFIX("prefix"),

    MESSAGES_REQUIRES_PERMISSION("messages.requires-permission"),
    MESSAGES_INVALID_ARGUMENT("messages.invalid-argument"),
    ;

    private final String key;

    I18nKeyType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
