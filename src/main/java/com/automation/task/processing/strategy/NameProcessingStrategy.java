package com.automation.task.processing.strategy;

import com.automation.task.processing.output.OutputHandler;

public class NameProcessingStrategy implements InputProcessingStrategy {
    private static final String JOHN_NAME = "John";
    private static final String JOHN_WELCOME = "Hello, John";
    private static final String NOT_MATCHED_NAME_MESSAGE = "There is no such name";

    @Override
    public void process(String inputString, OutputHandler outputHandler) {
        if (inputString.equalsIgnoreCase(JOHN_NAME)) {
            outputHandler.handle(JOHN_WELCOME);
        } else {
            outputHandler.handle(NOT_MATCHED_NAME_MESSAGE);
        }
    }
}
