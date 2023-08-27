package com.translator.translator.utils;

import com.deepl.api.Language;
import org.jetbrains.annotations.Nullable;

public class TranslateRequest {
    private String text;
    private String source;
    private String target;

    public TranslateRequest(){};

    public TranslateRequest(String text, @Nullable String source, String target) {
        this.text = text;
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
