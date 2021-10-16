package com.make.space.client;

import com.make.space.handler.MakeSpaceCommandHandler;
import com.make.space.interactions.CommandFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ClientTests {
    private static CommandFactory commandFactory;

    @BeforeAll
    public static void setup() {
        MakeSpaceCommandHandler makeSpaceCommandHandler = new MakeSpaceCommandHandler();
        commandFactory = CommandFactory.init(makeSpaceCommandHandler);
    }

    @Test
    public void handleInput_shouldHandleInput() {
        Client client = new FileClient(new BufferedReader(new StringReader("exit")), commandFactory);
        assertDoesNotThrow(() -> client.handleRequest());
    }
}
