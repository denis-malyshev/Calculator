package com.teamdev.calculator;

import com.teamdev.fsm.OutputContext;

import java.util.HashMap;
import java.util.Map;

public class EvaluationContext implements OutputContext {

    public static final EvaluationContextCloser DEFAULT_CLOSER = new EvaluationContextCloser() {

        @Override
        public void closeContext(EvaluationStack stack) throws CalculationError {

            stack.popAllOperators();

            stack.getParent().getOperandStack().push(
                    stack.getOperandStack().pop()
            );
        }
    };

    private EvaluationStack evaluationStack = new EvaluationStack();

    private EvaluationContextCloser actualCloser;

    private final Map<String, Double> variables = new HashMap<>();

    public void writeVariable(String name, double value) {
        variables.put(name, value);
    }

    public double readVariable(String name) throws CalculationError {
        if(variables.get(name)==null)
            throw new CalculationError("No such variable.");
        return variables.get(name);
    }

    public EvaluationStack getEvaluationStack() {
        return evaluationStack;
    }

    public void setActualCloser(EvaluationContextCloser actualCloser) {
        this.actualCloser = actualCloser;
    }

    public void enterNewContext() {
        final EvaluationContextCloser closer =
                actualCloser != null ? actualCloser : DEFAULT_CLOSER;

        evaluationStack = new EvaluationStack(evaluationStack, closer);

        actualCloser = null;
    }

    public void closeCurrentContext() throws CalculationError {
        final EvaluationContextCloser closer = evaluationStack.getCloser();
        closer.closeContext(evaluationStack);
        evaluationStack = evaluationStack.getParent();
    }

    public Map<String, Double> getVariables() {
        return variables;
    }
}
