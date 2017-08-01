package com.app.test.generators;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuvarej on 16/09/2016.
 */
public class SuiteClass {

    private String format;

    private String tags;

    private String features;

    public SuiteClass(String format, String tags, String features){
        this.format = format;
        this.tags = tags;
        this.features = features;
    }


    String generateFile(String phase, String randCode){
        try {
            TemplateUtil templateUtil = new TemplateUtil();
            templateUtil.load("templates/serenitysuite.vm");
            templateUtil.put("featureFile", this.features);
            templateUtil.put("tags", formatTags());
            templateUtil.put("format", format);
            templateUtil.put("testPhaseIdentifier", phase);
            templateUtil.put("randCode", randCode);
            templateUtil.fillTemplate();
            return templateUtil.getFilledTemplate();
        }
        catch (Exception ex){
            return "Failed";
        }
    }

    private String formatTags(){
        String[] splitTags = tags.split(",");
        List<String> tags = new ArrayList<>();
        for(String tag: splitTags){
            tags.add(tag.trim());
        }
        return String.format("\"%s\"",StringUtils.join(tags, "\",\""));
    }


}
