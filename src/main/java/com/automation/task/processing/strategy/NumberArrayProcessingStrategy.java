package com.automation.task.processing.strategy;

import com.automation.task.processing.output.OutputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberArrayProcessingStrategy implements InputProcessingStrategy {
    public static final String ELEMENTS_SEPARATOR = " ";
    private static final String ELEMENTS_SEPARATOR_REGEX = "\\s+";
    private static final int ELEMENTS_DIVISOR = 3;
    private static final String OUTPUT_MESSAGE_PREFIX = "Array elements that are multiples of " + ELEMENTS_DIVISOR + ": ";
    private static final String OUTPUT_MESSAGE_SUFFIX = "";
    private static final String NO_MULTIPLES_ELEMENTS_MESSAGE = "There are no elements in the array that are multiples of " + ELEMENTS_DIVISOR + ".";

    @Override
    public void process(String inputString, OutputHandler outputHandler) {
        String[] inputArray = inputString.split(ELEMENTS_SEPARATOR_REGEX);
        List<String> resultList = new ArrayList<>(inputArray.length);
        for (String item : inputArray) {
            try {
                double value = Double.parseDouble(item);
                if (value % ELEMENTS_DIVISOR == 0) {
                    resultList.add(item);
                }
            } catch (NumberFormatException exception) {
                outputHandler.handle(DEFAULT_OUTPUT_MESSAGE);
                return;
            }
        }

        if (resultList.isEmpty()) {
            outputHandler.handle(NO_MULTIPLES_ELEMENTS_MESSAGE);
            return;
        }

        outputHandler.handle(resultList.stream()
                .collect(Collectors.joining(ELEMENTS_SEPARATOR, OUTPUT_MESSAGE_PREFIX, OUTPUT_MESSAGE_SUFFIX)));
    }
}
