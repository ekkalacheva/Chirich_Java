package com.automation.task.processing.output;

@FunctionalInterface
public interface OutputHandler {
    void handle(String resultString);
}
