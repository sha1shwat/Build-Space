package com.make.space.client;

import com.make.space.exceptions.AlreadyBookedException;
import com.make.space.exceptions.InvalidParameterExceptions;
import com.make.space.interactions.CommandFactory;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Client {

    private CommandFactory commandFactory;
    private BufferedReader bufferedReader;

    public Client(CommandFactory commandFactory, BufferedReader bufferedReader) {
        this.commandFactory = commandFactory;
        this.bufferedReader = bufferedReader;
    }

    public void handleRequest() throws IOException {

        String readLine;

        Map<String, List<Pair<Integer, Integer>>> roomBookedIntervalsMap = new HashMap<>();

        while ((readLine = bufferedReader.readLine()) != null) {

            String[] inputChunks = readLine.split(" ");

            String command = inputChunks[0];
            String[] params = Arrays.copyOfRange(inputChunks,1, inputChunks.length);

            try {
                commandFactory.executeCommand(command, params);
            }catch ( InvalidParameterExceptions | AlreadyBookedException ex) {
                System.out.println(ex.getMessage());
            }


        }
    }
}
