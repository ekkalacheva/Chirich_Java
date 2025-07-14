package com.automation.task.processing.strategy;

import com.automation.task.processing.output.OutputHandler;

public class NumberProcessingStrategy implements InputProcessingStrategy {
    private static final int NUMBER_VALUE_FOR_PRINT_HELLO = 7;
    private static final String HELLO_MESSAGE = "Hello";

    @Override
    public void process(String inputString, OutputHandler outputHandler) {
        try {
            double value = Double.parseDouble(inputString);
            if (value > NUMBER_VALUE_FOR_PRINT_HELLO) {
                outputHandler.handle(HELLO_MESSAGE);
                return;
            }
        } catch (NumberFormatException exception) {
            outputHandler.handle(DEFAULT_OUTPUT_MESSAGE);
            return;
        }

        outputHandler.handle(DEFAULT_OUTPUT_MESSAGE);
    }
}
