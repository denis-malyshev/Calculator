package com.teamdev.fsm.test.parser;

import com.teamdev.fsm.test.EvaluationCommand;
import com.teamdev.fsm.test.EvaluationContext;
import com.teamdev.fsm.test.ExpressionParser;
import com.teamdev.fsm.test.MathExpressionReader;

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
            public void execute(EvaluationContext outputContext) {
                outputContext.getEvaluationStack().popAllOperators();
            }
        };
    }
}
