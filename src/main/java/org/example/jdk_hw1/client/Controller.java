package org.example.jdk_hw1.client;

import org.example.jdk_hw1.server.Server;

/**
 * Класс содержащий логику работы клиента
 *
 */
public class Controller {
    private Info info;
    private View view;
    //private ServerController server;
    private boolean connected;

    public Controller(View view, /*ServerController serverController*/) {
        this.view = view;
        //this.server = serverController;
        info = new Info();
    }

    public void connectedToServer() {

    }
}
