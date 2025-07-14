package com.automation.task;

import com.automation.task.processing.InputProcessingStrategyFactory;
import com.automation.task.processing.InputResolver;
import com.automation.task.processing.InputType;
import com.automation.task.processing.output.OutputHandler;
import com.automation.task.processing.strategy.ExitCommandProcessingStrategy;
import com.automation.task.processing.strategy.InputProcessingStrategy;

import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String START_INPUT_MESSAGE = "Please enter a number, a name or a list of numbers separated by spaces. Enter \"" + ExitCommandProcessingStrategy.EXIT_COMMAND + "\" to end the application:";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputResolver inputResolver = new InputResolver();
        Map<InputType, InputProcessingStrategy> processingStrategies = new InputProcessingStrategyFactory().getAllStrategies();
        OutputHandler consoleOutputHandler = (resultString -> System.out.println(resultString));

        while (true) {
            System.out.println(START_INPUT_MESSAGE);
            String inputString = scanner.nextLine().trim();

            InputType inputType = inputResolver.getInputType(inputString);
            processingStrategies.get(inputType).process(inputString, consoleOutputHandler);
        }
    }
}