package com.automation.task.processing.strategy;

public class NameProcessingStrategy implements InputProcessingStrategy {
    private static final String JOHN_NAME = "John";
    private static final String JOHN_WELCOME = "Hello, John";
    private static final String NOT_MATCHED_NAME_MESSAGE = "There is no such name";

    @Override
    public String getOutput(String inputString) {
        if (inputString.equals(JOHN_NAME)) {
            return JOHN_WELCOME;
        } else {
            return NOT_MATCHED_NAME_MESSAGE;
        }
    }
}
