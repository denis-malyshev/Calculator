package com.teamdev.calculator;

import com.teamdev.fsm.StateTransitionCommand;

public interface EvaluationCommand extends StateTransitionCommand<EvaluationStack,CalculationError> {

    @Override
    void execute(EvaluationStack outputContext) throws CalculationError;
}
