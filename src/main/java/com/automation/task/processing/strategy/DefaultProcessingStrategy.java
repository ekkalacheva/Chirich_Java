package com.automation.task.processing.strategy;

import com.automation.task.processing.output.OutputHandler;

public class DefaultProcessingStrategy implements InputProcessingStrategy {
    @Override
    public void process(String inputString, OutputHandler outputHandler) {
        outputHandler.handle(DEFAULT_OUTPUT_MESSAGE);
    }
}
