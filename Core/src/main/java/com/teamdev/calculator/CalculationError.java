package com.teamdev.calculator;

public class CalculationError extends Exception {

    private int errorPosition;

    public CalculationError(String message, int errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    public CalculationError(String message) {
        super(message);
    }

    public int getErrorPosition() {
        return errorPosition;
    }
}
