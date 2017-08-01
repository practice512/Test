package com.app.test.generators;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Yuvarej on 16/09/2016.
 */
public class TemplateUtil {

    private VelocityEngine engine = new VelocityEngine();
    private Template template = null;
    private VelocityContext context = new VelocityContext();
    private StringWriter writer = new StringWriter();

    public void load(String filePath) throws Exception {
        engine.init(getProperties());
        template = engine.getTemplate(filePath);
    }
    public void put(String templateKey, Object templateValue){
        context.put(templateKey, templateValue);
    }

    public void fillTemplate() throws IOException {
        template.merge(context, writer);
    }

    public String getFilledTemplate(){
        return writer.toString();
    }

    Properties getProperties(){
        Properties p = new Properties();
        p.setProperty("resource.loader","class");
        p.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return p;
    }

    public String getStringFromVmFile(Map<String,Object> templateProp, String vmFilePath) throws Exception{
        context = new VelocityContext(templateProp);
        load(vmFilePath);
        fillTemplate();
        return getFilledTemplate();
    }
}
