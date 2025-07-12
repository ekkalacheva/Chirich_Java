package com.automation.task.processing.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberArrayProcessingStrategy implements InputProcessingStrategy {
    public static final String ELEMENTS_SEPARATOR = " ";
    private static final String ELEMENTS_SEPARATOR_REGEX = "\\s+";
    private static final int ARRAY_MULTIPLIER = 3;

    @Override
    public String getOutput(String inputString) {
        String[] inputArray = inputString.split(ELEMENTS_SEPARATOR_REGEX);
        List<Integer> resultList = new ArrayList<>(inputArray.length);
        for (String item : inputArray) {
            try {
                int value = Integer.parseInt(item);
                resultList.add(value * ARRAY_MULTIPLIER);
            } catch (Exception exception) {
                return DEFAULT_OUTPUT_MESSAGE;
            }
        }

        return resultList.stream()
                .map(Object::toString)
                .collect(Collectors.joining(ELEMENTS_SEPARATOR));
    }
}
