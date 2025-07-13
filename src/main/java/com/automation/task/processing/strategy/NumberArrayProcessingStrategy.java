package com.automation.task.processing.strategy;

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
    public String getOutput(String inputString) {
        String[] inputArray = inputString.split(ELEMENTS_SEPARATOR_REGEX);
        List<String> resultList = new ArrayList<>(inputArray.length);
        for (String item : inputArray) {
            try {
                double value = Double.parseDouble(item);
                if (value % ELEMENTS_DIVISOR == 0) {
                    resultList.add(item);
                }
            } catch (NumberFormatException exception) {
                return DEFAULT_OUTPUT_MESSAGE;
            }
        }

        if (resultList.isEmpty()) {
            return NO_MULTIPLES_ELEMENTS_MESSAGE;
        }

        return resultList.stream()
                .collect(Collectors.joining(ELEMENTS_SEPARATOR, OUTPUT_MESSAGE_PREFIX, OUTPUT_MESSAGE_SUFFIX));
    }
}
