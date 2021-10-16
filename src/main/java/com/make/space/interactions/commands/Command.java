package com.make.space.interactions.commands;

import com.make.space.exceptions.AlreadyBookedException;
import com.make.space.exceptions.InvalidParameterExceptions;

public interface Command {

void execute(String[] params) throws InvalidParameterExceptions, AlreadyBookedException;
}
