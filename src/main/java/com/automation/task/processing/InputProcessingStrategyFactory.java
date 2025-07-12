package com.automation.task.processing;

import com.automation.task.processing.strategy.*;

import java.util.HashMap;
import java.util.Map;

public class InputProcessingStrategyFactory {
    private static final String UNSUPPORTED_INPUT_TYPE_MESSAGE = "Unsupported input type";

    public Map<InputType, InputProcessingStrategy> getAllStrategies() {
        Map<InputType, InputProcessingStrategy> strategies = new HashMap<>(InputType.values().length);
        for (InputType inputType : InputType.values()) {
            strategies.put(inputType, getStrategy(inputType));
        }
        return strategies;
    }

    private InputProcessingStrategy getStrategy(InputType inputType) {
        switch (inputType) {
            case Default:
                return new DefaultProcessingStrategy();
            case Number:
                return new NumberProcessingStrategy();
            case Name:
                return new NameProcessingStrategy();
            case NumberArray:
                return new NumberArrayProcessingStrategy();
            default:
                throw new RuntimeException(UNSUPPORTED_INPUT_TYPE_MESSAGE);
        }
    }
}
