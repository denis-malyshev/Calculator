package com.teamdev.calculator.parser;


import com.teamdev.calculator.EvaluationCommand;
import com.teamdev.calculator.EvaluationStack;
import com.teamdev.calculator.ExpressionParser;
import com.teamdev.calculator.MathExpressionReader;

public class RightBracket implements ExpressionParser {

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (!reader.hasMoreElements()) {
            return null;
        }

        final String expression = reader.getRemainingExpression();

        if (expression.startsWith(")")) {

            reader.movePosition(1);

            return new EvaluationCommand() {
                @Override
                public void execute(EvaluationStack outputContext) {
                    outputContext.popAllOperators();
                    double result=outputContext.getOperandStack().pop().pop();
                    outputContext.getOperandStack().peek().push(result);
                    outputContext.getOperatorStack().pop();
                }
            };
        }
        return null;
    }
}
