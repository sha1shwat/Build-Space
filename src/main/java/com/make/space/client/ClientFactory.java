package com.make.space.client;

import com.make.space.interactions.CommandFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ClientFactory {

    public static Client buildClient(String[] args, CommandFactory commandFactory) throws FileNotFoundException {

        return new FileClient(new BufferedReader(new FileReader(args[0])), commandFactory);

    }
}
