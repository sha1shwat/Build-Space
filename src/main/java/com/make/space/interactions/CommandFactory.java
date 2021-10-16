package com.make.space.interactions;

import com.make.space.exceptions.AlreadyBookedException;
import com.make.space.exceptions.InvalidParameterExceptions;
import com.make.space.handler.MakeSpaceCommandHandler;
import com.make.space.interactions.commands.BookCommand;
import com.make.space.interactions.commands.Command;
import com.make.space.interactions.commands.VacancyCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private Map<String, Command> commands;

    public CommandFactory(){
        commands = new HashMap<>();
    }

    public static CommandFactory init(MakeSpaceCommandHandler makeSpaceCommandHandler){

       CommandFactory cf = new CommandFactory();
       cf.addCommands("VACANCY",new VacancyCommand(makeSpaceCommandHandler));
       cf.addCommands("BOOK",new BookCommand(makeSpaceCommandHandler));
       return cf;

    }

    private void addCommands(String name, Command command) {

        commands.put(name,command);
    }

    public void executeCommand(String name, String[] params) throws InvalidParameterExceptions, AlreadyBookedException {

        if(commands.containsKey(name)){
            commands.get(name).execute(params);
        }
    }
}
