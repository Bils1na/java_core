package org.example.jdk_hw1;

import org.example.jdk_hw1.client.ClientUI;
import org.example.jdk_hw1.client.Controller;
import org.example.jdk_hw1.server.Server;
import org.example.jdk_hw1.server.ServerController;

public class Program {

    public static void main(String[] args) {
        Server server = new Server();
        ServerController serverController = new ServerController(server);
        server.setController(serverController);


        ClientUI client1 = new ClientUI();
        Controller controller1 = new Controller(client1, serverController);
        client1.setController(controller1);


        ClientUI client2 = new ClientUI();
        Controller controller2 = new Controller(client2, serverController);
        client2.setController(controller2);
    }
}
