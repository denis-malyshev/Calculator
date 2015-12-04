package com.teamdev.calculator;

import com.teamdev.fsm.StateAcceptor;

public interface ExpressionParser extends StateAcceptor<
        MathExpressionReader,
        EvaluationContext,
        CalculationError,
        EvaluationCommand> {

    @Override
    EvaluationCommand accept(MathExpressionReader reader);
}
