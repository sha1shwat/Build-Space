package com.make.space.interactions.commands;

import com.make.space.exceptions.AlreadyBookedException;
import com.make.space.exceptions.InvalidParameterExceptions;
import com.make.space.handler.MakeSpaceCommandHandler;
import com.make.space.validator.Validator;

public class VacancyCommand implements Command{

    private MakeSpaceCommandHandler makeSpaceCommandHandler;
    private Validator validator = new Validator();

    public VacancyCommand(MakeSpaceCommandHandler makeSpaceCommandHandler) {
        this.makeSpaceCommandHandler = makeSpaceCommandHandler;
    }

    @Override
    public void execute(String[] params) throws InvalidParameterExceptions, AlreadyBookedException {

        if (params.length <2){
            throw new InvalidParameterExceptions("INCORRECT_INPUT");
        }else{
            try {
                validator.validateRequest(params[0], params[1]);
                makeSpaceCommandHandler.findStatus(params);
            } catch (InvalidParameterExceptions | AlreadyBookedException ex){
                throw ex;
            }

        }
    }
}
