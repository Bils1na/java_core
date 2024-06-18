package org.example.jdk_hw1.client;

import org.example.jdk_hw1.server.ServerController;

/**
 * Класс содержащий логику работы клиента
 *
 */
public class Controller {
    private Info info;
    private View view;
    private ServerController server;
    private boolean connected;

    public Controller(View view, ServerController server) {
        this.view = view;
        this.server = server;
        info = new Info();
    }

    public boolean connectToServer(String name) {
        if (server.connectUser(this)) {
            info.setName(name);
            connected = true;
            view.connectedToServer();
            showOnWindow("Вы успешно подключились!\n");
            String log = server.getHistory();
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
            view.disconnectedFromServer();
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
                server.message(info.getName() + ": " + text);
            }
        } else {
            showOnWindow("Нет подключения к серверу.\n");
        }
    }

    protected void showOnWindow(String text) {
        view.showMessage(text);
    }

}
