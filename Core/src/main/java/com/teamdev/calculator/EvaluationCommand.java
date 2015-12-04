package com.teamdev.fsm.test;

import com.teamdev.fsm.StateTransitionCommand;

public interface EvaluationCommand extends StateTransitionCommand<EvaluationContext> {

    @Override
    void execute(EvaluationContext outputContext);
}
