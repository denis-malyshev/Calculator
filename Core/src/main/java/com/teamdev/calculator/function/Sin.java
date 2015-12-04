package com.teamdev.calculator.function;

import java.util.Optional;

public class Sin extends AbstractFunction {

    public Sin() {
        super(1, 1);
    }

    @Override
    public Optional<Double> execute(double... arguments) {
        double result = Math.sin(arguments[0] * Math.PI / 180);
        return Optional.of(result);
    }
}
