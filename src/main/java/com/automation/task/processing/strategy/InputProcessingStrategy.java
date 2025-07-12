package com.automation.task.processing.strategy;

public interface InputProcessingStrategy {
    String DEFAULT_OUTPUT_MESSAGE = "Nothing to display: the input did not match any condition.";

    String getOutput(String inputString);
}
