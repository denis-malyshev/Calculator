package com.teamdev.calculator.parser;
import com.teamdev.calculator.EvaluationCommand;
import com.teamdev.calculator.EvaluationStack;
import com.teamdev.calculator.ExpressionParser;
import com.teamdev.calculator.MathExpressionReader;

public class EndOfExpressionParser implements ExpressionParser {

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (reader.hasMoreElements()) {
            return null;
        }

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationStack outputContext) {
                outputContext.popAllOperators();
            }
        };
    }
}
