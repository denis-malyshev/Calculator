package com.teamdev.calculator.parser;
import com.teamdev.calculator.*;

public class EndOfExpressionParser implements ExpressionParser {

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (reader.hasMoreElements()) {
            return null;
        }

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationStack outputContext) throws CalculationError {

                if (outputContext.getOperandStack().size() > 1) {
                    throw new CalculationError("Unexpected right bracket.", reader.getPosition());
                }

                outputContext.popAllOperators();
            }
        };
    }
}
