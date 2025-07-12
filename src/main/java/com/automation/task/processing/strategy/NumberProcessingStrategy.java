package com.automation.task.processing.strategy;

public class NumberProcessingStrategy implements InputProcessingStrategy {
    private static final int NUMBER_VALUE_FOR_PRINT_HELLO = 7;
    private static final String HELLO_MESSAGE = "Hello";

    @Override
    public String getOutput(String inputString) {
        int value = Integer.parseInt(inputString);
        if (value > NUMBER_VALUE_FOR_PRINT_HELLO) {
            return HELLO_MESSAGE;
        }

        return DEFAULT_OUTPUT_MESSAGE;
    }
}
