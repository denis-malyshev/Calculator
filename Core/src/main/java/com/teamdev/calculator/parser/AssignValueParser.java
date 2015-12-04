package com.teamdev.fsm.test.parser;

import com.teamdev.fsm.test.EvaluationCommand;
import com.teamdev.fsm.test.EvaluationContext;
import com.teamdev.fsm.test.ExpressionParser;
import com.teamdev.fsm.test.MathExpressionReader;

public class AssignValueParser implements ExpressionParser {

    public static final String ASSIGN = "=";

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (!reader.hasMoreElements()) {
            return null;
        }

        if (!reader.getRemainingExpression().startsWith(ASSIGN)) {
            return null;
        }

        reader.movePosition(ASSIGN.length());

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationContext outputContext) {
                outputContext.enterNewContext();
            }
        };
    }
}
