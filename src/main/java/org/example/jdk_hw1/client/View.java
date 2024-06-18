package org.example.jdk_hw1.client;

public interface View {
    void answerFromServer(String text);
    void disconnectFromServer();
    void connectToServer();
}
