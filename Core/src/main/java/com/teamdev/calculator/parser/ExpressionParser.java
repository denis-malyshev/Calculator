package com.teamdev.calculator.parser;

import com.teamdev.calculator.CalculationError;
import com.teamdev.calculator.EvaluationCommand;
import com.teamdev.calculator.EvaluationContext;
import com.teamdev.calculator.MathExpressionReader;
import com.teamdev.fsm.StateAcceptor;

public interface ExpressionParser extends StateAcceptor<
        MathExpressionReader,
        EvaluationContext,
        CalculationError,
        EvaluationCommand> {

    @Override
    EvaluationCommand accept(MathExpressionReader reader);
}
