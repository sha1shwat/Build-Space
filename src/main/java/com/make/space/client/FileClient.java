package com.make.space.client;

import com.make.space.interactions.CommandFactory;

import java.io.BufferedReader;

public class FileClient extends Client {

    public FileClient(BufferedReader inputReader, CommandFactory commandFactory) {
        super(commandFactory, inputReader);
    }
}
