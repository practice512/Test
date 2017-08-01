package com.app.test.formatter;

import cucumber.runtime.formatter.CucumberJSONFormatter;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.formatter.Formatter;
import gherkin.formatter.JSONFormatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuvaraj on 20/07/2017.
 */
public class JSONScenarioFormatter implements Reporter, Formatter {

    private File reportFile;
    private CucumberJSONFormatter cucumberJSONFormatter;

    public JSONScenarioFormatter(File file){
        reportFile = file;
        cucumberJSONFormatter = new CucumberJSONFormatter(null);
    }

    @Override
    public void syntaxError(String s, String s1, List<String> list, String s2, Integer integer) {
        cucumberJSONFormatter.syntaxError(s,s1, list, s2, integer);
    }

    @Override
    public void uri(String s) {
        cucumberJSONFormatter.uri(s);
    }

    @Override
    public void feature(Feature feature) {
        cucumberJSONFormatter.feature(feature);
    }

    @Override
    public void scenarioOutline(ScenarioOutline scenarioOutline) {
        cucumberJSONFormatter.scenarioOutline(scenarioOutline);
    }

    @Override
    public void examples(Examples examples) {
        cucumberJSONFormatter.examples(examples);
    }

    @Override
    public void startOfScenarioLifeCycle(Scenario scenario) {
        cucumberJSONFormatter.startOfScenarioLifeCycle(scenario);
    }

    @Override
    public void background(Background background) {
        cucumberJSONFormatter.background(background);
    }

    @Override
    public void scenario(Scenario scenario) {
        cucumberJSONFormatter.scenario(scenario);
    }

    @Override
    public void step(Step step) {
        cucumberJSONFormatter.step(step);
    }

    @Override
    public void endOfScenarioLifeCycle(Scenario scenario) {
        try {
            Field field = cucumberJSONFormatter.getClass().getSuperclass().getDeclaredField("featureMaps");
            field.setAccessible(true);
            List<Map<String, Object>> featureMaps = (List<Map<String, Object>>)field.get(cucumberJSONFormatter);
            FileUtils.write(reportFile, gson().toJson(featureMaps), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void done() {
    }

    @Override
    public void close() {
        cucumberJSONFormatter.close();
    }

    @Override
    public void eof() {
        cucumberJSONFormatter.eof();
    }

    @Override
    public void before(Match match, Result result) {
        cucumberJSONFormatter.before(match, result);
    }

    @Override
    public void result(Result result) {
        cucumberJSONFormatter.result(result);
    }

    @Override
    public void after(Match match, Result result) {
        cucumberJSONFormatter.after(match, result);
    }

    @Override
    public void match(Match match) {
        cucumberJSONFormatter.match(match);
    }

    @Override
    public void embedding(String s, byte[] bytes) {
        cucumberJSONFormatter.embedding(s, bytes);
    }

    @Override
    public void write(String s) {
        cucumberJSONFormatter.write(s);
    }

    protected Gson gson() {
        return (new GsonBuilder()).setPrettyPrinting().create();
    }
}
