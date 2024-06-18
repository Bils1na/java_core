package org.example.jdk_hw1.client;

public interface View {
    void showMessage(String text);
    void disconnectedFromServer();
    void connectedToServer();
}
