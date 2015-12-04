package com.teamdev.calculator.function;


import com.teamdev.calculator.CalculationError;

import java.util.Optional;

public class Sqrt extends AbstractFunction {
    public Sqrt() {
        super(1, 1);
    }

    @Override
    public Optional<Double> execute(double... arguments) throws CalculationError {
        if (arguments[0] < 0)
            throw new CalculationError("Negative value.");
        double result = Math.sqrt(arguments[0]);
        return Optional.of(result);
    }
}
