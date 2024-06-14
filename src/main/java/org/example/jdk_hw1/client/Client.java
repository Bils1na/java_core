package org.example.jdk_hw1.client;

import org.example.jdk_hw1.server.Server;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    JTextField ip, port, username, message;
    JPasswordField password;
    JButton btnLogin, btnSend;
    JTextArea chat;

    public Client(Server server) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        setTitle("Client chat");
        setResizable(false);
        JPanel loginInputPanel = new JPanel(new GridLayout(2, 3));
        JPanel loginPanel = new JPanel(new GridLayout(1, 2));
        JPanel messagePanel = new JPanel(new GridLayout(1, 2));
        ip = new JTextField();
        port = new JTextField();
        username = new JTextField();
        password = new JPasswordField();
        btnLogin = new JButton("login");
        loginInputPanel.add(ip);
        loginInputPanel.add(port);
        loginInputPanel.add(username);
        loginInputPanel.add(password);
        chat = new JTextArea();
        chat.setEditable(false);
        chat.setFocusable(false);
        message = new JTextField();
        btnSend = new JButton("send");
        loginPanel.add(loginInputPanel);
        loginPanel.add(btnLogin);
        messagePanel.add(message);
        messagePanel.add(btnSend);
        add(loginPanel, BorderLayout.NORTH);
        add(chat, BorderLayout.CENTER);
        add(messagePanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
