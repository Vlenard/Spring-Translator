package com.translator.translator.utils;

import org.jetbrains.annotations.Nullable;

public class TranslateResponse {
    private String translatedText;
    private String errorMessage;

    public TranslateResponse() {
    }

    public TranslateResponse(@Nullable String translatedText,  @Nullable String errorMessage) {
        this.translatedText = translatedText;
        this.errorMessage = errorMessage;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
