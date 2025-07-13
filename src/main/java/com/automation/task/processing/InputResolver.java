package com.automation.task.processing;

import com.automation.task.processing.strategy.NumberArrayProcessingStrategy;

public class InputResolver {
    private static final String NUMERIC_REGEX = "[-+]?\\d+(\\.\\d+)?(\\s+[-+]?\\d+(\\.\\d+)?)*";

    public InputType getInputType(String inputString) {
        if (!inputString.isEmpty()) {
            boolean isNumericInput = inputString.matches(NUMERIC_REGEX);
            if (isNumericInput) {
                if (inputString.contains(NumberArrayProcessingStrategy.ELEMENTS_SEPARATOR)) {
                    return InputType.NumberArray;
                } else {
                    return InputType.Number;
                }
            }
            return InputType.Name;
        }

        return InputType.Default;
    }
}
