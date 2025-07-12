package com.automation.task.processing.strategy;

public class DefaultProcessingStrategy implements InputProcessingStrategy{
    @Override
    public String getOutput(String inputString) {
        return DEFAULT_OUTPUT_MESSAGE;
    }
}
