package com.teamdev.fsm.test;

import java.util.Optional;

public interface Function {

    int ANY_ARGUMENTS = -1;

    Optional<Double> execute(double... arguments);

    int getMinArgumentCount();

    int getMaxArgumentCount();
}
