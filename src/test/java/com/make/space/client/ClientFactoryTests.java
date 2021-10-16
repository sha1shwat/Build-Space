package com.make.space.client;

import com.make.space.handler.MakeSpaceCommandHandler;
import com.make.space.interactions.CommandFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClientFactoryTests {

    private static CommandFactory commandFactory;

    @BeforeAll
    public static void commandFactory() {
        MakeSpaceCommandHandler makeSpaceCommandHandler = new MakeSpaceCommandHandler();
        commandFactory = CommandFactory.init(makeSpaceCommandHandler);
    }


    @Test
    public void buildClientWithValidFilePath_shouldCreateFileClient() throws FileNotFoundException {
        String[] args = {"file_input.txt"};
        Client client = ClientFactory.buildClient(args, commandFactory);

        assertTrue(client instanceof FileClient);
    }

    @Test
    public void buildClientWithInvalidFilePath_shouldThrowError() throws FileNotFoundException {
        String[] args = {"invalid_file_path.txt"};
        assertThrows(FileNotFoundException.class, () -> ClientFactory.buildClient(args, commandFactory));
    }

}
