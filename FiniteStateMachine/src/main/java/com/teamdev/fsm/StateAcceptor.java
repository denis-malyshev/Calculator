package com.teamdev.fsm;


public interface StateAcceptor<

        Input extends InputContext,
        Output extends OutputContext,
        Error extends Exception,
        Command extends StateTransitionCommand<Output, Error>> {

    Command accept(Input inputContext);
}
