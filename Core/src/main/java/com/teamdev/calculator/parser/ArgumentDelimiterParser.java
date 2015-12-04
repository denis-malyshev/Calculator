package com.teamdev.calculator.parser;

import com.teamdev.calculator.*;

public class ArgumentDelimiterParser implements ExpressionParser {

    public static final String DELIMITER = ",";

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (!reader.hasMoreElements()) {
            return null;
        }

        if (!reader.getRemainingExpression().startsWith(DELIMITER)) {
            return null;
        }

        reader.movePosition(DELIMITER.length());

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationContext outputContext) throws CalculationError {
                outputContext.getEvaluationStack().popAllOperators();
            }
        };
    }
}
