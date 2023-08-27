package com.translator.translator.utils;

import com.deepl.api.Language;

import java.util.List;

public class SupportedLanguages {
    List<Language> source;
    List<Language> target;

    public SupportedLanguages(){}
    public SupportedLanguages(List<Language> source, List<Language> target){
        this.source = source;
        this.target = target;
    }

    public List<Language> getSource() {
        return source;
    }

    public void setSource(List<Language> source) {
        this.source = source;
    }

    public List<Language> getTarget() {
        return target;
    }

    public void setTarget(List<Language> target) {
        this.target = target;
    }
}
