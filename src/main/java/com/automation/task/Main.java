package com.automation.task;

import com.automation.task.processing.InputProcessingStrategyFactory;
import com.automation.task.processing.InputResolver;
import com.automation.task.processing.InputType;
import com.automation.task.processing.strategy.InputProcessingStrategy;

import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String START_INPUT_MESSAGE = "Please enter a number, a name or a list of numbers separated by spaces:";

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        InputResolver inputResolver = new InputResolver();
        Map<InputType, InputProcessingStrategy> processingStrategies = new InputProcessingStrategyFactory().getAllStrategies();

        while (true) {
            System.out.println(START_INPUT_MESSAGE);
            String inputString = scanner.nextLine().trim();
            InputType inputType = inputResolver.getInputType(inputString);
            String outputString = processingStrategies.get(inputType).getOutput(inputString);
            System.out.println(outputString);
        }
    }
}