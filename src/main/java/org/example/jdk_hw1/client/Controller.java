package org.example.jdk_hw1.client;

import org.example.jdk_hw1.server.Server;

/**
 * Класс содержащий логику работы клиента
 *
 */
public class Controller {
    private Info info;
    private View view;
    private ServerController server;
    private boolean connected;

    public Controller(View view /*ServerController serverController*/) {
        this.view = view;
        //this.server = serverController;
        info = new Info();
    }

    public boolean connectToServer(String name) {
        if (server.connectUser(this)) {
            connected = true;
            view.connectToServer();
            showOnWindow("Вы успешно подключились!\n");
            log = server.getHistory();
            if (log != null) {
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow("Подключение не удалось.\n");
            return false;
        }

    }

    public void disconnectedFromServer() {
        if (connected) {
            connected = false;
            view.disconnectFromServer();
            showOnWindow("Вы были отключены от сервера!\n");
        }
    }

    public void disconnectFromServer() {
        server.disconnectUser(this);
    }

    public void answerFromServer(String text) {
        showOnWindow(text);
    }

    public void message(String text) {
        if (connected) {
            if (!text.isEmpty()) {
                server.message(name + ": " + text);
            }
        } else {
            showOnWindow("Нет подключения к серверу.\n");
        }
    }

    private void showOnWindow(String text) {
        view.showMessage(text);
    }

}
