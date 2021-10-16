package com.make.space.interactions.commands;

import com.make.space.exceptions.AlreadyBookedException;
import com.make.space.exceptions.InvalidParameterExceptions;
import com.make.space.handler.MakeSpaceCommandHandler;
import com.make.space.validator.Validator;

public class BookCommand implements Command{

    private MakeSpaceCommandHandler makeSpaceCommandHandler;
    private Validator validator = new Validator();

    public BookCommand(MakeSpaceCommandHandler makeSpaceCommandHandler) {
        this.makeSpaceCommandHandler = makeSpaceCommandHandler;
    }

    @Override
    public void execute(String[] params) throws InvalidParameterExceptions, AlreadyBookedException {

        if (params.length <3){
            throw new InvalidParameterExceptions("INCORRECT_INPUT");
        }else{
            try {
                validator.validateRequest(params[0], params[1]);
                makeSpaceCommandHandler.bookSpace(params);
            } catch (InvalidParameterExceptions | AlreadyBookedException ex){
                throw ex;
            }

        }

    }
}
