package com.translator.translator.controllers;

import com.translator.translator.services.TranslatorService;
import com.translator.translator.utils.SupportedLanguages;
import com.translator.translator.utils.TranslateRequest;
import com.translator.translator.utils.TranslateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TranslatorController {

    private TranslatorService translatorService;

    @Autowired
    public void setTranslatorService(TranslatorService translatorService) {
        this.translatorService = translatorService;
    }

    @GetMapping("/getSupportedLanguages")
    @ResponseBody
    public SupportedLanguages getAuthKey(){
        return translatorService.getSupportedLanguages();
    }

    @PostMapping("/translate")
    @ResponseBody
    public TranslateResponse translate(@RequestBody TranslateRequest req){
        return translatorService.translate(req);
    }
}
