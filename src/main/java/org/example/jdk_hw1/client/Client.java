package org.example.jdk_hw1.client;

import org.example.jdk_hw1.server.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    JTextField ip, port, username, message;
    JPasswordField password;
    JButton btnLogin, btnSend;
    JTextArea chat;

    private boolean isLogin;
    private String usernameChat, messageChat;
    private String logChat = "";

    public Client(Server server) {
        isLogin = false;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        setTitle("Client chat");
        setResizable(false);

        JPanel loginInputPanel = new JPanel(new GridLayout(2, 3));
        JPanel loginPanel = new JPanel(new GridLayout(1, 2));
        JPanel messagePanel = new JPanel(new GridLayout(1, 2));
        ip = new JTextField("127.0.0.1");
        port = new JTextField("8150");
        username = new JTextField();
        password = new JPasswordField("123456");
        btnLogin = new JButton("login");
        message = new JTextField();
        btnSend = new JButton("send");
        chat = new JTextArea();
        chat.setEditable(false);

        loginInputPanel.add(ip);
        loginInputPanel.add(port);
        loginInputPanel.add(username);
        loginInputPanel.add(password);
        loginPanel.add(loginInputPanel);
        loginPanel.add(btnLogin);
        messagePanel.add(message);
        messagePanel.add(btnSend);

        add(loginPanel, BorderLayout.NORTH);
        add(chat, BorderLayout.CENTER);
        add(messagePanel, BorderLayout.SOUTH);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.isServerWorking()) {
                    chat.setText("Server is stopped.\n");
                } else {
                    if (!isLogin) {
                        usernameChat = username.getText();
                        logChat += "Welcome, " + usernameChat + "\n"
                        + server.getChatHistory();
                        loginPanel.remove(loginInputPanel);
                        loginPanel.remove(btnLogin);
                        loginPanel.repaint();
                        System.out.println(server.getChatHistory());
                        chat.setText(logChat);
                    }
                    isLogin = true;
                    chat.setText(logChat);

                    server.setLogHistory(server.getLogHistory() + (usernameChat + " connected.\n"));
                    server.getLog().setText(server.getLogHistory());
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLogin && server.isServerWorking()) {
                    messageChat = message.getText();
                    logChat += usernameChat + ": " + messageChat + "\n";
                    chat.setText(logChat);

                    server.setChatHistory(server.getChatHistory() + (usernameChat + ": " + messageChat + "\n"));
                    server.getLog().setText((server.getLogHistory() + "\n" + server.getChatHistory()));
                } else {
                    chat.setText("Server is stopped.\n");
                }
            }
        });

        setVisible(true);
    }

}
