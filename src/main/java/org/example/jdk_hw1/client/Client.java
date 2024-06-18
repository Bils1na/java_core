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
    private Server server;
    private JPanel loginPanel;
    private String usernameChat, messageChat;


    public Client(Server server) {
        isLogin = false;
        this.server = server;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        setTitle("Client chat");
        setResizable(false);

        createPanel();

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.isServerWorking()) {
                    chat.setText("Server is stopped.\n");
                } else {
                    
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLogin && server.isServerWorking()) {
                    
                } else {
                    chat.setText("Server is stopped.\n");
                }
            }
        });

        setVisible(true);
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog(), BorderLayout.CENTER);
        add(createFooterPanel(), BorderLayout.SOUTH);
    }

    private Component createFooterPanel() {
        JPanel messagePanel = new JPanel(new GridLayout(1, 2));
        message = new JTextField();
        btnSend = new JButton("send");
        messagePanel.add(message);
        messagePanel.add(btnSend);
        return messagePanel;
    }

    private Component createLog() {
        chat = new JTextArea();
        chat.setEditable(false);
        return chat;
    }

    private Component createHeaderPanel() {
        JPanel loginInputPanel = new JPanel(new GridLayout(2, 3));
        loginPanel = new JPanel(new GridLayout(1, 2));
        ip = new JTextField("127.0.0.1");
        port = new JTextField("8150");
        username = new JTextField();
        password = new JPasswordField("123456");
        btnLogin = new JButton("login");

        loginInputPanel.add(ip);
        loginInputPanel.add(port);
        loginInputPanel.add(username);
        loginInputPanel.add(password);
        loginPanel.add(loginInputPanel);
        loginPanel.add(btnLogin);

        return loginPanel;
    }

    private void connectToServer() {
        
    }

    private void answer(String text) {
        appendLog(text);
    }

    private void appendLog(String text) {
        chat.append(text + "\n");
    }

}
