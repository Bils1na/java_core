package org.example.jdk_hw1.server;

import org.example.jdk_hw1.client.ClientUI;
import org.example.jdk_hw1.client.Controller;
import org.example.jdk_hw1.client.View;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ServerController {
    private static final String LOG_PATH = "src/main/java/org/example/jdk_hw1/server/log.txt";

    private boolean work;
    private ArrayList<Controller> onlineUsers;
    private ServerView view;

    public ServerController(ServerView view) {
        this.view = view;
        work = false;
        onlineUsers = new ArrayList<>();
    }

    public String getHistory() {
        return readLog();
    }

    public void message(String text) {
        if (!work) {
            return;
        }

        view.showMessage(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text) {
        for (Controller controller : onlineUsers) {
            controller.answerFromServer(text);
        }
    }

    private String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean connectUser(Controller client) {
        if (work) {
            if (!onlineUsers.contains(client)) {
                onlineUsers.add(client);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void disconnectUser(Controller controller) {
        if (controller != null && onlineUsers.contains(controller)) {
            onlineUsers.remove(controller);
            controller.disconnectedFromServer();
        }
    }

    public void startServer() {
        if (work) {
            view.showMessage("Сервер уже запущен.\n");
        } else {
            work = true;
            view.showMessage("Сервер запущен.\n");
        }
    }

    public void stopServer() {
        if (!work) {
            view.showMessage("Сервер отключен.\n");
        } else {
            work = false;
            while (!onlineUsers.isEmpty()) {
                disconnectUser(onlineUsers.get(onlineUsers.size()-1));
            }
        }
    }

}
