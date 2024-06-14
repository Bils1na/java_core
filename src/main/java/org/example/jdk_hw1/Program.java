package org.example.jdk_hw1;

import org.example.jdk_hw1.client.Client;
import org.example.jdk_hw1.server.Server;

public class Program {

    public static void main(String[] args) {
        Server server = new Server();
        new Client(server);
        new Client(server);
    }
}
