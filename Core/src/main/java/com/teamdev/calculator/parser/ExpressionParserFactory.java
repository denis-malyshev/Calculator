package com.teamdev.calculator.parser;

import com.teamdev.calculator.*;

import java.util.HashMap;
import java.util.Map;

import static com.teamdev.calculator.CalculationState.*;

public class ExpressionParserFactory {

    private final Map<CalculationState, ExpressionParser> parsers =
            new HashMap<CalculationState, ExpressionParser>() {{

                put(NUMBER, new NumberParser());
                put(BINARY_OPERATOR, new BinaryOperatorParser());
                put(LEFT_BRACKET, new LeftBracketParser());
                put(RIGHT_BRACKET, new RightBracket());
                put(FINISH, new EndOfExpressionParser());
            }};

    public ExpressionParser getParser(CalculationState state) {

        if (!parsers.containsKey(state)) {
            throw new RuntimeException("Parser not found for " +
                    CalculationState.class.getName() +
                    "." + state.toString());

        }

        return parsers.get(state);
    }
}
