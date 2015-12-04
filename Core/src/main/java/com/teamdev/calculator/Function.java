package com.teamdev.calculator;

import java.util.Optional;

public interface Function {

    int ANY_ARGUMENTS = -1;

    Optional<Double> execute(double... arguments) throws CalculationError;

    int getMinArgumentCount();

    int getMaxArgumentCount();
}
