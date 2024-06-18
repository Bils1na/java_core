package org.example.jdk_hw1.client;

import org.example.jdk_hw1.server.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowEvent;

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

        message.addKeyListener((KeyAdapter) e -> {
            if (e.getKeyChar() == '\n') {
                message();
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });

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

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        return loginPanel;
    }

    private void connectToServer() {
        if (server.connectUser(this)) {
            appendLog("Вы успешно подключились!\n");
            loginPanel.setVisible(false);
            isLogin = true;
            usernameChat = username.getText();
            String log = server.getLogHistory();
            if (log != null) {
                appendLog(log);
            }
        } else {
            appendLog("Подключение не удалось.\n");
        }
    }

    public void disconnectFromServer() {
        if (isLogin) {
            loginPanel.setVisible(true);
            isLogin = false;
            server.disconnectUser(this);
            appendLog("Вы были отключены от сервера!\n");
        }
    }

    public void message() {
        if (isLogin) {
            messageChat = message.getText();
            if (!text.equals("")) {
                server.message(usernameChat + ": " + messageChat);
                message.setText("");
            }
        } else {
            appendLog("Нет подключения к серверу!");
        }
    }

    public void answer(String text) {
        appendLog(text);
    }

    private void appendLog(String text) {
        chat.append(text + "\n");
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            disconnectFromServer();
        }
        super.processWindowEvent(e);
    }

}
