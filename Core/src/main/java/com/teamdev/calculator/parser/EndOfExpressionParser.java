package com.teamdev.fsm.test.parser;

import com.teamdev.fsm.test.EvaluationCommand;
import com.teamdev.fsm.test.EvaluationContext;
import com.teamdev.fsm.test.ExpressionParser;
import com.teamdev.fsm.test.MathExpressionReader;

public class EndOfExpressionParser implements ExpressionParser {

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (reader.hasMoreElements()) {
            return null;
        }

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationContext outputContext) {
                outputContext.getEvaluationStack().popAllOperators();
            }
        };
    }
}
