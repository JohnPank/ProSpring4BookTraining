package com.johnpank.prospring4.chapter14;

import javax.script.ScriptEngineManager;

public class ScriptEngineTest {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        manager.getEngineFactories().forEach(factory ->{
            String engineName = factory.getEngineName();
            String languageName = factory.getLanguageName();
            String version = factory.getLanguageVersion();
            System.out.println("Engine name: " + engineName
            + " Language:" + languageName
            + " Versoin:" + version);
        });
    }
}
