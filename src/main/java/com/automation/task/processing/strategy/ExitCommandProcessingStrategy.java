package com.automation.task.processing.strategy;

import com.automation.task.processing.output.OutputHandler;

public class ExitCommandProcessingStrategy implements InputProcessingStrategy{
    public static final String EXIT_COMMAND = "exit";
    private static final String APPLICATION_EXIT_MESSAGE = "Application terminated.";

    @Override
    public void process(String inputString, OutputHandler outputHandler) {
        outputHandler.handle(APPLICATION_EXIT_MESSAGE);
        System.exit(0);
    }
}
