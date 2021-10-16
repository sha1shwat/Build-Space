package com.make.space;


import com.make.space.client.Client;
import com.make.space.client.ClientFactory;
import com.make.space.handler.MakeSpaceCommandHandler;
import com.make.space.interactions.CommandFactory;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {


    public static void main(String[] args) throws IOException {

        MakeSpaceCommandHandler makeSpaceCommandHandler = new MakeSpaceCommandHandler();
        CommandFactory commandFactory = CommandFactory.init(makeSpaceCommandHandler);
        Client client = ClientFactory.buildClient(args, commandFactory);
        client.handleRequest();

    }
}
