package com.automation.task.processing.strategy;

import com.automation.task.processing.output.OutputHandler;

public interface InputProcessingStrategy {
    String DEFAULT_OUTPUT_MESSAGE = "Nothing to display: the input did not match any condition.";

    void process(String inputString, OutputHandler outputHandler);
}
