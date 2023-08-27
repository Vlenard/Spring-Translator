package com.translator.translator.services;

import com.deepl.api.Language;
import com.deepl.api.TextResult;
import com.deepl.api.Translator;
import com.translator.translator.utils.SupportedLanguages;
import com.translator.translator.utils.TranslateRequest;
import com.translator.translator.utils.TranslateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslatorService {
    private static final Logger logger = LoggerFactory.getLogger(TranslatorService.class);
    private final Translator translator;
    public TranslatorService(@Value("${deepl.authKey}") String authKey){
        translator = new Translator(authKey);
    }

    public SupportedLanguages getSupportedLanguages(){
        try {
            List<Language> source = translator.getSourceLanguages();
            List<Language> target = translator.getTargetLanguages();

            return new SupportedLanguages(source, target);
        }catch (Exception exception){
            logger.error("Something goes wrong with deepl api ");
        }

        return null;
    }

    public TranslateResponse translate(TranslateRequest req){
        try {
            TextResult res = translator.translateText(req.getText(), req.getSource(), req.getTarget());
            return new TranslateResponse(res.getText(), null);
        }catch (Exception ex) {
            logger.error("Something goes wrong with deepl api");
            return new TranslateResponse(null, ex.getMessage());
        }
    }
}
